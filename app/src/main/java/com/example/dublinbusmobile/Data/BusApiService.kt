package com.example.dublinbusmobile.Data

import retrofit2.http.GET
import retrofit2.http.Path

interface BusApiService {
    @GET("api/stops")
    suspend fun getStops(): List<Stop>

    @GET("api/stops/{id}/vehicles")
    suspend fun getVehiclesNearStop(@Path("id") stopId: String): VehiclesResponse
}