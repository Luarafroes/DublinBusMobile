package com.example.dublinbusmobile.Data

interface BusRepository {
    suspend fun getStops(): List<Stop>
    suspend fun getVehiclesNearStop(stopId: String): List<Bus>
}

class MockBusRepository : BusRepository {
    private val stops = listOf(
        Stop(id = "1234", name = "O'Connell Street", latitude = 53.3498, longitude = -6.2603),
        Stop(id = "5678", name = "Trinity College", latitude = 53.3438, longitude = -6.2546),
        Stop(id = "9012", name = "Heuston Station", latitude = 53.3467, longitude = -6.2944)
    )

    override suspend fun getStops(): List<Stop> = stops

    override suspend fun getVehiclesNearStop(stopId: String): List<Bus> = listOf(
        Bus(vehicleId = "BUS001", routeNumber = "46A", direction = "Phoenix Park",
            latitude = 53.3510, longitude = -6.2595, distanceMeters = 450.0),
        Bus(vehicleId = "BUS002", routeNumber = "145", direction = "Heuston Station",
            latitude = 53.3489, longitude = -6.2612, distanceMeters = 850.0)
    )
}

class ApiBusRepository(private val api: BusApiService) : BusRepository {
    override suspend fun getStops(): List<Stop> = api.getStops()

    override suspend fun getVehiclesNearStop(stopId: String): List<Bus> =
        api.getVehiclesNearStop(stopId).vehicles
}