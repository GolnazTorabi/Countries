package com.golnaz.countries.domain.repository

import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.domain.model.*
import kotlinx.coroutines.flow.Flow

interface CountriesRepository {
    suspend fun getAllCountries(): Flow<List<ResponseCountriesItem?>?>

    suspend fun getAllCountriesFromDB(): Flow<List<CountryRelation>>
    suspend fun saveToDB(data: List<CountryModel>)
    suspend fun saveLanguagesToDB(data: List<LanguageModel>?)
    suspend fun saveCurrenciesToDB(data: List<CurrencyModel>)
    suspend fun insertLanguageCountry(data: List<LanguageCountryCross>)
    suspend fun getCountries() : Flow<List<CountryModel>>
    suspend fun getCurrencies() : Flow<List<CurrencyModel>>
    //suspend fun getLanguages(data: String):Flow<List<LanguageModel>>
}