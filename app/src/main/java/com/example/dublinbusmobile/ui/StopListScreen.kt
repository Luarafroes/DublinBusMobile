
package com.example.dublinbusmobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dublinbusmobile.Data.Stop

@Composable
fun StopListScreen(
    onStopClick: (Stop) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: StopListViewModel = viewModel()
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

        // Back to Home button
        TextButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("← Home")
        }

        Text(
            text = "Bus Stops",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (viewModel.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(viewModel.stops) { stop ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        onClick = {
                            onStopClick(stop)
                        }
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = stop.name,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = "Stop ${stop.id}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}
