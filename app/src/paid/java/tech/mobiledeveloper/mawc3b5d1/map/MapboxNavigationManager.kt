package tech.mobiledeveloper.mawc3b5d1.map

import android.location.Location
import com.mapbox.maps.MapboxMap

class MapboxNavigationManager: MapManager {
    private var mapboxNavigation: MapboxMap? = null

    override fun initMap() {
        // Инициализация Mapbox Navigation
    }

    override fun displayRoute(route: List<Location>) {
        // Используем Mapbox для отображения продвинутого маршрута
    }

    companion object {
        fun getInstance() = MapboxNavigationManager()
    }
}