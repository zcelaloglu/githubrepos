package com.celaloglu.zafer.domain.usecases

import com.celaloglu.zafer.database.BookmarkEntity
import com.celaloglu.zafer.domain.repository.IBookmarkRepository

class InsertBookmarkUseCase(private val IBookmarkRepository: IBookmarkRepository) {

    suspend operator fun invoke(bookmarkEntity: BookmarkEntity) =
        IBookmarkRepository.insertBookmark(bookmarkEntity)
}