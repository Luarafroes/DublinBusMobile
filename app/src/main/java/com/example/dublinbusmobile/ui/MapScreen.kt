package com.example.dublinbusmobile.ui

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@Composable
fun MapScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Back to Home button
        TextButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("← Home")
        }

        // Map
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(650.dp),

            factory = { context ->

                WebView(context).apply {

                    webViewClient = WebViewClient()

                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true

                    loadDataWithBaseURL(
                        "https://localhost/",
                        """
                        <!DOCTYPE html>
                        <html>

                        <head>

                            <meta
                                name="viewport"
                                content="width=device-width, initial-scale=1.0"
                            >

                            <link
                                rel="stylesheet"
                                href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"
                            >

                            <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js">
                            </script>

                            <style>
                                html, body {
                                    margin: 0;
                                    padding: 0;
                                    width: 100%;
                                    height: 100%;
                                }

                                #map {
                                    width: 100%;
                                    height: 100%;
                                }
                            </style>

                        </head>

                        <body>

                            <div id="map"></div>

                            <script>

                                var map = L.map('map').setView(
                                    [53.3498, -6.2603],
                                    12
                                );

                                L.tileLayer(
                                    'https://basemaps.cartocdn.com/rastertiles/voyager/{z}/{x}/{y}.png?key=YOUR_KEY_HERE',
                                    {
                                        attribution:
                                            '&copy; OpenStreetMap contributors &copy; CARTO',
                                        maxZoom: 19
                                    }
                                ).addTo(map);

                            </script>

                        </body>

                        </html>
                        """.trimIndent(),
                        "text/html",
                        "UTF-8",
                        null
                    )
                }
            }
        )
    }
}