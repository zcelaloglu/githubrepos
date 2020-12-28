package com.celaloglu.zafer.features.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.celaloglu.zafer.commons.Status
import com.celaloglu.zafer.domain.usecases.GetBookmarkUseCase
import com.celaloglu.zafer.domain.usecases.GetReposUseCase
import com.celaloglu.zafer.features.viewstates.ReposViewState
import com.celaloglu.zafer.models.ReposItem
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ReposViewModel(
    private val getReposUseCase: GetReposUseCase,
    private val getBookmarkUseCase: GetBookmarkUseCase
) : ViewModel() {

    private var _viewState = MutableLiveData<ReposViewState>()

    val viewState: LiveData<ReposViewState>
        get() = _viewState


    fun getRepos(user: String) {
        _viewState.value = ReposViewState(status = Status.LOADING)
        viewModelScope.launch(handler) {
            getReposUseCase.invoke(user).collect { results ->
                results.updateRepos()
                _viewState.value = ReposViewState(data = results, status = Status.SUCCESS)
            }
        }
    }

    fun getUpdatedRepos() {
        viewModelScope.launch(handler) {
            viewState.value?.getRepos()?.updateRepos()
            _viewState.value = ReposViewState(data = viewState.value?.getRepos(), status = Status.SUCCESS)
        }
    }

    private val handler = CoroutineExceptionHandler { _, exception ->
        _viewState.value = ReposViewState(error = exception, status = Status.FAILED)
    }

    @JvmName("updateReposReposItem")
    suspend fun List<ReposItem>.updateRepos() {
        this.forEach { data ->
            val bookmark = getBookmarkUseCase.invoke(data.githubId)
            data.isBookmarked = bookmark != null
        }
    }

}
