package tech.mobiledeveloper.companyA

import kotlinx.coroutines.delay

class HttpClient(
    private val baseUrl: String,
    private val apiKey: String
) {

    suspend fun makeRequest(): String {
        delay(1000)
        return "Result"
    }
}