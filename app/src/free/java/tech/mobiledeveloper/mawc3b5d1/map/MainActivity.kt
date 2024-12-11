package tech.mobiledeveloper.mawc3b5d1

import BasicMapManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import tech.mobiledeveloper.mawc3b5d1.screens.MapScreen
import tech.mobiledeveloper.mawc3b5d1.ui.theme.MAWC3B5D1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val mapManager = BasicMapManager.getInstance()

        setContent {
            MAWC3B5D1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MapScreen(innerPadding, mapManager)
                }
            }
        }
    }
}