package com.celaloglu.zafer.domain.usecases

import com.celaloglu.zafer.domain.repository.IBookmarkRepository

class DeleteBookmarkUseCase(private val IBookmarkRepository: IBookmarkRepository) {

    suspend operator fun invoke(id: Long) = IBookmarkRepository.deleteBookmark(id)
}