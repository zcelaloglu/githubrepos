package com.celaloglu.zafer.datasource

import com.celaloglu.zafer.api.ApiService
import com.celaloglu.zafer.models.ReposItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetReposDataSource(private val api: ApiService) {

    suspend fun get(user: String): Flow<List<ReposItem>> {

        val repoItems = api.getRepos(user).map { response ->
            ReposItem(
                githubId = response.id,
                userName = response.owner?.login,
                repoName= response.name,
                avatarUrl = response.owner?.avatarUrl,
                stargazersCount = response.stargazersCount,
                openIssueCount = response.openIssuesCount,
                isBookmarked = false
            )
        }
        return flow { emit((repoItems)) }
    }
}