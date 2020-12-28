package com.celaloglu.zafer.features.repo_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.celaloglu.zafer.database.BookmarkEntity
import com.celaloglu.zafer.domain.usecases.DeleteBookmarkUseCase
import com.celaloglu.zafer.domain.usecases.GetBookmarkCountUseCase
import com.celaloglu.zafer.domain.usecases.InsertBookmarkUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepoDetailViewModel(
    private val getBookmarkCountUseCase: GetBookmarkCountUseCase,
    private val insertBookmarkUseCase: InsertBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase
) : ViewModel() {

    private var _uiState = MutableLiveData<Int>()

    val uiState: LiveData<Int>
        get() = _uiState

    fun getBookmarkStatus(repositoryId: Long) {
        viewModelScope.launch {
            getBookmarkCountUseCase.invoke(repositoryId).collect {
                _uiState.value = it
            }
        }
    }

    fun addBookmark(githubId: Long) {
        viewModelScope.launch {
            insertBookmarkUseCase.invoke(BookmarkEntity(githubId))
        }
    }

    fun deleteBookmark(githubId: Long) {
        viewModelScope.launch {
            deleteBookmarkUseCase.invoke(githubId)
        }
    }

}