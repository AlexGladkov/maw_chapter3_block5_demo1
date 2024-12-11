package tech.mobiledeveloper.mawc3b5d1.map

import android.location.Location

interface MapManager {
    fun initMap()
    fun displayRoute(route: List<Location>)

    companion object {
        fun getInstance(): MapManager {
            throw NotImplementedError("Will be provided by flavor sources.")
        }
    }
}