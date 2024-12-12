package tech.mobiledeveloper.mawc3b5d1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import tech.mobiledeveloper.company_b.CompanyBTheme
import tech.mobiledeveloper.core.HttpClient
import tech.mobiledeveloper.core.LocalHttpClient
import tech.mobiledeveloper.mawc3b5d1.map.MapboxNavigationManager
import tech.mobiledeveloper.mawc3b5d1.screens.MapScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val mapManager = MapboxNavigationManager()
        val httpClient = HttpClient(BuildConfig.BASE_URL, BuildConfig.API_KEY)

        setContent {
            CompositionLocalProvider(
                LocalHttpClient provides httpClient
            ) {
                CompanyATheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MapScreen(innerPadding, mapManager)
                    }
                }
            }
        }
    }
}