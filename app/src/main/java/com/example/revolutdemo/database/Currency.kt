package com.example.revolutdemo.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//@Entity
data class Currency(
    /*@field:PrimaryKey(autoGenerate = true)
    @Transient
    var id: Int,*/
    var base: String,
    var date: String,
    var rates: Map<String, Float>
)