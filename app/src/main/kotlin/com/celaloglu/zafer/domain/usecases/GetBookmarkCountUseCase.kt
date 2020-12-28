package com.celaloglu.zafer.domain.usecases

import com.celaloglu.zafer.domain.repository.IBookmarkRepository

class GetBookmarkCountUseCase(private val IBookmarkRepository: IBookmarkRepository) {

    suspend operator fun invoke(id: Long) = IBookmarkRepository.getBookmarkCount(id)
}