package com.example.revolutdemo.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
//import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
//import com.example.revolutdemo.database.AppDatabase
import com.example.revolutdemo.ui.CurrencyListViewModel

class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrencyListViewModel::class.java)) {
            //val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()
            @Suppress("UNCHECKED_CAST")
            return CurrencyListViewModel(/*db.postDao()*/) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}