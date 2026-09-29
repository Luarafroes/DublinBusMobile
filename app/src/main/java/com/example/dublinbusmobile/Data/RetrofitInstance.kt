package com.example.dublinbusmobile.Data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // 10.0.2.2 is how the Android emulator reaches "localhost" on your own machine
    private const val BASE_URL = "http://10.0.2.2:5000/"

    val api: BusApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BusApiService::class.java)
    }
}