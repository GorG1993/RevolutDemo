package com.example.revolutdemo.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CurrencyViewModel : ViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()


    fun bind(pair: Pair<String, Float>) {
        postTitle.value = pair.first
        postBody.value = pair.second.toString()
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}