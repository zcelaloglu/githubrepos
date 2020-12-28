package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.datasource.BookmarkDataSource
import com.celaloglu.zafer.datasource.GetReposDataSource
import org.koin.dsl.module

val dataSourceModule = module {

    single { GetReposDataSource(get()) }

    single { BookmarkDataSource(get()) }
}