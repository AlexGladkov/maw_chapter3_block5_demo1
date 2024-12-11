package tech.mobiledeveloper.mawc3b5d1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import tech.mobiledeveloper.companyA.CompanyATheme
import tech.mobiledeveloper.mawc3b5d1.map.MapboxNavigationManager
import tech.mobiledeveloper.mawc3b5d1.screens.MapScreen
import tech.mobiledeveloper.mawc3b5d1.ui.theme.MAWC3B5D1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val mapManager = MapboxNavigationManager.getInstance()
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