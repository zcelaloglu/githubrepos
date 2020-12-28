package com.celaloglu.zafer.repository

import com.celaloglu.zafer.datasource.GetReposDataSource
import com.celaloglu.zafer.domain.repository.IGetReposRepository
import com.celaloglu.zafer.models.ReposItem
import kotlinx.coroutines.flow.Flow

class GetReposRepository(
    private val getReposDataSource: GetReposDataSource
) : IGetReposRepository {

    override suspend fun getRepos(user: String): Flow<List<ReposItem>> {
        return getReposDataSource.get(user)
    }
}