package com.example.dublinbusmobile.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dublinbusmobile.Data.RepositoryProvider
import com.example.dublinbusmobile.Data.Stop
import kotlinx.coroutines.launch

class StopListViewModel : ViewModel() {
    var stops by mutableStateOf<List<Stop>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        loadStops()
    }

    fun loadStops() {
        viewModelScope.launch {
            isLoading = true
            stops = RepositoryProvider.repository.getStops()
            isLoading = false
        }
    }
}