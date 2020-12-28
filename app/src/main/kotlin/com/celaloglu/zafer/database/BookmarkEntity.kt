package com.celaloglu.zafer.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("githubId", unique = true)])
class BookmarkEntity(var githubId: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}