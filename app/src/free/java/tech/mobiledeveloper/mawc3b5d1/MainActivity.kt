package tech.mobiledeveloper.mawc3b5d1

import BasicMapManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import tech.mobiledeveloper.companyA.HttpClient
import tech.mobiledeveloper.companyA.LocalHttpClient
import tech.mobiledeveloper.mawc3b5d1.screens.MapScreen
import tech.mobiledeveloper.mawc3b5d1.ui.theme.MAWC3B5D1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val mapManager = BasicMapManager.getInstance()
        val httpClient = HttpClient(BuildConfig.BASE_URL, BuildConfig.API_KEY)

        setContent {
            CompositionLocalProvider(
                LocalHttpClient provides httpClient
            ) {
                MAWC3B5D1Theme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MapScreen(innerPadding, mapManager)
                    }
                }
            }
        }
    }
}