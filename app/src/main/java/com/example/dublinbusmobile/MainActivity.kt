package com.example.dublinbusmobile
import com.example.dublinbusmobile.ui.BusNavHost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.dublinbusmobile.ui.StopListScreen
import com.example.dublinbusmobile.ui.theme.DublinBusMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DublinBusMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusNavHost()
                }
            }
        }
    }
}