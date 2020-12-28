package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.domain.usecases.*
import org.koin.dsl.module

val useCasesModule = module {
    
    single { GetReposUseCase(get()) }

    single { GetBookmarkCountUseCase(get()) }

    single { InsertBookmarkUseCase(get()) }

    single { DeleteBookmarkUseCase(get()) }

    single { GetBookmarkUseCase(get()) }
}