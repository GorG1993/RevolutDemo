package com.example.revolutdemo.network

import com.example.revolutdemo.database.Currency
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/latest?}")
    fun getCurrencies(@Query("base") base: String): Observable<Currency>
}