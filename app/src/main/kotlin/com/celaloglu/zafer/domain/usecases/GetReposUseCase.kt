package com.celaloglu.zafer.domain.usecases

import com.celaloglu.zafer.domain.repository.IGetReposRepository

class GetReposUseCase(private val iGetReposRepository: IGetReposRepository) {

    suspend operator fun invoke(user: String) = iGetReposRepository.getRepos(user)
}