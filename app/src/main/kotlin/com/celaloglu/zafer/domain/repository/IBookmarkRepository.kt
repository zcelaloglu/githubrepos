package com.celaloglu.zafer.domain.repository

import com.celaloglu.zafer.database.BookmarkEntity
import kotlinx.coroutines.flow.Flow

interface IBookmarkRepository {

    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)

    suspend fun deleteBookmark(githubId: Long)

    suspend fun getBookmarkCount(repositoryId: Long): Flow<Int>

    suspend fun getBookmark(repositoryId: Long): BookmarkEntity?
}