package com.example.dublinbusmobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Back button and title
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back"
                )
            }

            Text(
                text = "Bus Stops",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.isLoading) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

        } else {

            LazyColumn(
                modifier = Modifier.fillMaxSize()
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

                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            // Stop number
                            Surface(
                                color = MaterialTheme.colorScheme.primary,
                                shape = MaterialTheme.shapes.small
                            ) {
                                Text(
                                    text = stop.id,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.padding(
                                        horizontal = 12.dp,
                                        vertical = 8.dp
                                    ),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            // Stop name
                            Column {
                                Text(
                                    text = stop.name,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = "Bus Stop",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}