package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.database.BookmarkDatabase
import org.koin.dsl.module

val databaseModule = module {

    single { BookmarkDatabase.getDatabase(get()) }

}