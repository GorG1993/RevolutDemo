package com.example.revolutdemo.di

import com.example.revolutdemo.ui.CurrencyListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelComponent {

    fun inject(target: CurrencyListViewModel)


    @Component.Builder
    interface Builder {
        fun build(): ViewModelComponent

        fun networkModule(networkModule: NetworkModule): Builder
    }
}