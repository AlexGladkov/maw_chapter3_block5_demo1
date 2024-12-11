package tech.mobiledeveloper.companyA

import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.delay

class HttpClient(
    val baseUrl: String,
    val apiKey: String
) {

    suspend fun makeRequest(): String {
        delay(1000)
        return "Result"
    }
}

val LocalHttpClient = staticCompositionLocalOf<HttpClient> { error("No default implementation") }