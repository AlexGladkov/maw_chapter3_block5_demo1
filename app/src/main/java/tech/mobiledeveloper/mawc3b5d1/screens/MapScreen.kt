package tech.mobiledeveloper.mawc3b5d1.screens

import android.content.Context
import android.location.Location
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import tech.mobiledeveloper.companyA.LocationProvider
import tech.mobiledeveloper.companyA.RouteCalculator
import tech.mobiledeveloper.mawc3b5d1.map.MapManager

@Composable
fun MapScreen(paddingValues: PaddingValues, mapManager: MapManager) {
    val context = LocalContext.current

    val locationProvider = remember { LocationProvider(context) }
    val routeCalculator = remember { RouteCalculator() }

    val destination = Location("").apply {
        // Moscow coordinates
        latitude = 55.751244
        longitude = 37.618423
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(modifier = Modifier.align(Alignment.Center), onClick = {
            Toast.makeText(context, "Class $mapManager", Toast.LENGTH_SHORT).show()
            val current = locationProvider.getCurrentLocation() ?: return@Button
            val route = routeCalculator.calculateDistance(current, destination)
            mapManager.displayRoute(route)
        }) {
            Text("Show Route", fontSize = 36.sp)
        }
    }

    // Здесь можно отрисовать карту (при помощи MapView в Compose или простого Surface),
    // Но для примера предположим, что карта рендерится нативно, а мы просто взаимодействуем через mapManager.
    // На практике, для Mapbox можно использовать MapboxCompose SDK или AndroidView для рендеринга.

    LaunchedEffect(Unit) {
        mapManager.initMap()
    }
}