package com.golnaz.countries.utils.database

import android.content.Context
import androidx.room.Room
import com.golnaz.countries.data.local.dao.CountriesDao
import com.golnaz.countries.data.local.dao.CurrencyDao
import com.golnaz.countries.data.local.dao.LanguageCountryDao
import com.golnaz.countries.data.local.dao.LanguageDao
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideCountriesDao(database: AppDatabase): CountriesDao {
        return database.countriesDao()
    }

    @Provides
    @Singleton
    fun provideCurrenciesDao(database: AppDatabase): CurrencyDao {
        return database.currenciesDao()
    }

    @Provides
    @Singleton
    fun provideCountryLanguageDao(database: AppDatabase): LanguageCountryDao {
        return database.countryLanguageDao()
    }

    @Provides
    @Singleton
    fun provideLanguageDao(database: AppDatabase): LanguageDao {
        return database.languageDao()
    }


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "App_Data.db"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
}
