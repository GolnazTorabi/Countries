package com.golnaz.countries.utils.repository

import com.golnaz.countries.data.repository.CountriesRepositoryImpl
import com.golnaz.countries.domain.repository.CountriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideCountriesRepository(repo : CountriesRepositoryImpl):CountriesRepository = repo
}