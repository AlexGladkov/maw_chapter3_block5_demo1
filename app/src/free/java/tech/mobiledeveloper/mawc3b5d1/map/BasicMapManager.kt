import android.location.Location
import tech.mobiledeveloper.mawc3b5d1.map.MapManager

class BasicMapManager: MapManager {
    override fun initMap() {
        // Инициализация базовой карты (допустим, просто статический фон или базовый провайдер)
    }

    override fun displayRoute(route: List<Location>) {
        // Отображение простого маршрута на базовой карте (условно)
    }

    companion object {
        fun getInstance() = BasicMapManager()
    }
}