package com.amroid.dose.data.datasources.remote

import retrofit2.http.GET

interface DiseaseApi {
    @GET("/v3/0b63b4fc-3f0e-49f6-adbc-3ddfd8cd3853")
    suspend fun getDisease(): DiseaseResponse


    companion object {
        const val BASE_URL = "https://run.mocky.io"
    }
}