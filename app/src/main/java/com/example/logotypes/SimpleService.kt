package com.example.logotypes

import retrofit2.http.GET

interface SimpleService {
    @GET("all")
    suspend fun getAllLogos(): ApiResponse
}
