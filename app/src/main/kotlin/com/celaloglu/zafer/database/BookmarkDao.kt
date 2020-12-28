package com.celaloglu.zafer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query("Select Count(*) FROM BookmarkEntity where githubId = :repoId")
    fun getBookmarkCount(repoId: Long): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)

    @Query("Delete from BookmarkEntity where githubId = :repoId")
    suspend fun deleteBookmark(repoId: Long)

    @Query("SELECT * FROM BookmarkEntity where githubId = :repoId")
    suspend fun getBookmark(repoId: Long): BookmarkEntity?
}