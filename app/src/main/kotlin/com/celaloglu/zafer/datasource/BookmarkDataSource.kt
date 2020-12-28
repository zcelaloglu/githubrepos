package com.celaloglu.zafer.datasource

import com.celaloglu.zafer.database.BookmarkDatabase
import com.celaloglu.zafer.database.BookmarkEntity
import kotlinx.coroutines.flow.Flow

class BookmarkDataSource(private val db: BookmarkDatabase) {

    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) {
        db.bookmarkDao().insertBookmark(bookmarkEntity)
    }

    suspend fun deleteBookmark(id: Long) {
        db.bookmarkDao().deleteBookmark(id)
    }

    fun getBookmarkCount(id: Long): Flow<Int> {
        return db.bookmarkDao().getBookmarkCount(id)
    }

    suspend fun getBookmark(id: Long): BookmarkEntity? {
        return db.bookmarkDao().getBookmark(id)
    }

}