package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.features.repo_detail.RepoDetailViewModel
import com.celaloglu.zafer.features.repos.ReposViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ReposViewModel(get(), get()) }

    viewModel { RepoDetailViewModel(get(), get(), get()) }

}