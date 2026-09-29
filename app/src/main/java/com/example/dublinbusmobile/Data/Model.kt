package com.example.dublinbusmobile.Data

data class Stop(
    val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double
)

data class VehiclesResponse(
    val stopId: String,
    val vehicles: List<Bus>
)

data class Bus(
    val vehicleId: String,
    val routeNumber: String,
    val direction: String,
    val latitude: Double,
    val longitude: Double,
    val distanceMeters: Double
)