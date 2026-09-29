package com.example.dublinbusmobile.Data

object RepositoryProvider {
    // Switch this one line to flip between mock and real data —
    // same idea as your C# Program.cs DI registration
    val repository: BusRepository = MockBusRepository()
    // val repository: BusRepository = ApiBusRepository(RetrofitInstance.api)
}