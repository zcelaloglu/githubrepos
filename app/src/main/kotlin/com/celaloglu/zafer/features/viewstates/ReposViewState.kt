package com.celaloglu.zafer.features.viewstates

import com.celaloglu.zafer.commons.Status
import com.celaloglu.zafer.models.ReposItem

class ReposViewState(
    val status: Status,
    private val error: Throwable? = null,
    private val data: List<ReposItem>? = null
) {
    fun getRepos() = data ?: mutableListOf()

    fun isLoading() = status == Status.LOADING

    fun isSuccess() = status == Status.SUCCESS

    fun getErrorMessage() = error?.message

    fun shouldShowErrorMessage() = error != null
}