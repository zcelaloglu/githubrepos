package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.domain.repository.IBookmarkRepository
import com.celaloglu.zafer.domain.repository.IGetReposRepository
import com.celaloglu.zafer.repository.BookmarkRepository
import com.celaloglu.zafer.repository.GetReposRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single<IGetReposRepository> { GetReposRepository(get()) }

    single<IBookmarkRepository> { BookmarkRepository(get()) }
}