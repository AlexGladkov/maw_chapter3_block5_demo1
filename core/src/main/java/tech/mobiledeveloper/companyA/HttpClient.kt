package tech.mobiledeveloper.companyA

import kotlinx.coroutines.delay

class HttpClient {

    suspend fun makeRequest(): String {
        delay(1000)
        return "Result"
    }
}