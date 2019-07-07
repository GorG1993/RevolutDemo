package com.example.revolutdemo.base

import android.arch.lifecycle.ViewModel
import com.example.revolutdemo.di.DaggerViewModelComponent
import com.example.revolutdemo.di.NetworkModule
import com.example.revolutdemo.di.ViewModelComponent
import com.example.revolutdemo.ui.CurrencyListViewModel

abstract class BaseViewModel : ViewModel() {
    private val component: ViewModelComponent = DaggerViewModelComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    fun inject() {
        when (this) {
            is CurrencyListViewModel -> component.inject(this)
        }
    }

}