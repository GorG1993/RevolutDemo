package com.example.revolutdemo.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.revolutdemo.ui.CurrencyListViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrencyListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CurrencyListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}