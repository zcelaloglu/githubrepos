package com.celaloglu.zafer.repository

import com.celaloglu.zafer.database.BookmarkEntity
import com.celaloglu.zafer.datasource.BookmarkDataSource
import com.celaloglu.zafer.domain.repository.IBookmarkRepository
import kotlinx.coroutines.flow.Flow

class BookmarkRepository(
    private val dataSource: BookmarkDataSource
) : IBookmarkRepository {

    override suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) {
        dataSource.insertBookmark(bookmarkEntity)
    }

    override suspend fun deleteBookmark(githubId: Long) {
        dataSource.deleteBookmark(githubId)
    }

    override suspend fun getBookmarkCount(repositoryId: Long) : Flow<Int> {
        return dataSource.getBookmarkCount(repositoryId)
    }

    override suspend fun getBookmark(repositoryId: Long): BookmarkEntity? {
        return dataSource.getBookmark(repositoryId)
    }
}