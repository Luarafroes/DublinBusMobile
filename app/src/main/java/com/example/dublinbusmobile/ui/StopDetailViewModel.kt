package com.example.dublinbusmobile.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dublinbusmobile.Data.Bus
import com.example.dublinbusmobile.Data.RepositoryProvider
import kotlinx.coroutines.launch

class StopDetailViewModel : ViewModel() {
    var buses by mutableStateOf<List<Bus>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadBuses(stopId: String) {
        viewModelScope.launch {
            isLoading = true
            buses = RepositoryProvider.repository.getVehiclesNearStop(stopId)
            isLoading = false
        }
    }
}