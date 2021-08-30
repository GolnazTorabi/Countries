package com.golnaz.countries.data.repository

import com.golnaz.countries.data.api.CountriesApiImpl
import com.golnaz.countries.data.local.dao.CountriesDao
import com.golnaz.countries.data.local.dao.CurrencyDao
import com.golnaz.countries.data.local.dao.LanguageCountryDao
import com.golnaz.countries.data.local.dao.LanguageDao
import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.domain.model.*
import com.golnaz.countries.domain.repository.CountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val countriesApiImpl: CountriesApiImpl,
    private val countriesDao: CountriesDao,
    private val languageDao: LanguageDao,
    private val currencyDao: CurrencyDao,
    private val languageCountryDao: LanguageCountryDao
) :
    CountriesRepository {
    override suspend fun getAllCountries(): Flow<List<ResponseCountriesItem?>?> = flow {
        val response = countriesApiImpl.getAllCountries()
        emit(response)

    }.flowOn(Dispatchers.IO)

    override suspend fun saveToDB(data: List<CountryModel>) {
        countriesDao.insert(data)
    }

    override suspend fun saveLanguagesToDB(data: List<LanguageModel>?) {
        if (data != null) {
            languageDao.insert(data)
        }
    }

    override suspend fun saveCurrenciesToDB(data: List<CurrencyModel>) {
        currencyDao.insert(data)
    }

    override suspend fun insertLanguageCountry(data: List<LanguageCountryCross>) {
        languageCountryDao.insert(data)
    }

    override suspend fun getCountries(): Flow<List<CountryModel>>  = flow{
        val result =  countriesDao.getAllCountriess()
        emit(result)
    }

    override suspend fun getCurrencies(): Flow<List<CurrencyModel>> = flow{
        val result =  currencyDao.getAllCurrency()
        emit(result)
    }
/*
    override suspend fun getLanguages(data: String): Flow<List<LanguageModel>> = flow {
        val result = languageDao.getAllLanguages()
        emit(result)
    }*/


    override suspend fun getAllCountriesFromDB(): Flow<List<CountryRelation>> = flow {
        val result = countriesDao.getAllCountries()
        emit(result)
    }.flowOn(Dispatchers.IO)

}