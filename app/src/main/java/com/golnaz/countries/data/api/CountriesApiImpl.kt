package com.golnaz.countries.data.api

import com.golnaz.countries.data.local.response.ResponseCountries
import com.golnaz.countries.data.local.response.ResponseCountriesItem
import javax.inject.Inject

class CountriesApiImpl @Inject constructor(private val countriesApi: CountriesApi) {
    suspend fun getAllCountries(): List<ResponseCountriesItem?>? {
        return countriesApi.getAllCountries()
    }
}