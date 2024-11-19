package com.example.logotypes

import retrofit2.http.GET

interface SimpleService {
    @GET("logos") // Sesuaikan endpoint API untuk mendapatkan daftar logo
    suspend fun getLogos(): List<ApiResponse>
}
