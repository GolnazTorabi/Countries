package com.golnaz.countries.data.api

import com.golnaz.countries.data.local.response.ResponseCountries
import retrofit2.http.GET

interface CountriesApi {

    @GET("/v2/all")
    suspend fun getAllCountries(): ResponseCountries

}