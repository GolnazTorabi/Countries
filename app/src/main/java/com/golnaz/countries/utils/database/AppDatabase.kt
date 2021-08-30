package com.golnaz.countries.utils.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.golnaz.countries.data.local.dao.CountriesDao
import com.golnaz.countries.data.local.dao.CurrencyDao
import com.golnaz.countries.data.local.dao.LanguageCountryDao
import com.golnaz.countries.data.local.dao.LanguageDao
import com.golnaz.countries.domain.model.CountryModel
import com.golnaz.countries.domain.model.CurrencyModel
import com.golnaz.countries.domain.model.LanguageCountryCross
import com.golnaz.countries.domain.model.LanguageModel

@Database(
    entities = [CountryModel::class, LanguageModel::class, LanguageCountryCross::class, CurrencyModel::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countriesDao(): CountriesDao
    abstract fun currenciesDao(): CurrencyDao
    abstract fun countryLanguageDao(): LanguageCountryDao
    abstract fun languageDao(): LanguageDao
}
