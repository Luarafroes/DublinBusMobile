
package com.example.dublinbusmobile.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun BusNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // Home
        composable("home") {
            HomeScreen(
                onStopsClick = {
                    navController.navigate("stopList")
                },
                onMapClick = {
                    navController.navigate("map")
                }
            )
        }

        // Stop list
        composable("stopList") {
            StopListScreen(
                onStopClick = { stop ->
                    navController.navigate(
                        "stopDetail/${stop.id}/${stop.name}"
                    )
                },
                navController = navController
            )
        }
        // Stop details
        composable(
            route = "stopDetail/{stopId}/{stopName}",
            arguments = listOf(
                navArgument("stopId") {
                    type = NavType.StringType
                },
                navArgument("stopName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val stopId =
                backStackEntry.arguments?.getString("stopId") ?: ""

            val stopName =
                backStackEntry.arguments?.getString("stopName") ?: ""

            StopDetailScreen(
                stopId = stopId,
                stopName = stopName,
                navController = navController
            )
        }

        // Map
        composable("map") {
            MapScreen(
                navController = navController
            )

        }
    }
}
