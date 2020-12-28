package com.celaloglu.zafer.domain.repository

import com.celaloglu.zafer.models.ReposItem
import kotlinx.coroutines.flow.Flow

interface IGetReposRepository {
    suspend fun getRepos(user: String): Flow<List<ReposItem>>
}