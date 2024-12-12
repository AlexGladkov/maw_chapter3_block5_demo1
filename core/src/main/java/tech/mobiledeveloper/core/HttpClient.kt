package tech.mobiledeveloper.core

import androidx.compose.runtime.staticCompositionLocalOf

class HttpClient(val baseUrl: String, val apiKey: String) {
    suspend fun makeRequest(): String = ""
}

val LocalHttpClient = staticCompositionLocalOf<HttpClient> { error("no default") }