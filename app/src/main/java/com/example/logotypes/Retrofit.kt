package com.example.logotypes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val BASE_URL="https://logotypes.dev"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
    val retrofitService:SimpleService by lazy{
        getInstance().create(SimpleService::class.java)
    }
}