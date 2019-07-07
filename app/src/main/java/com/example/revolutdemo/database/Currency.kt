package com.example.revolutdemo.database

data class Currency(
    var base: String,
    var date: String,
    var rates: Map<String, Float>
)