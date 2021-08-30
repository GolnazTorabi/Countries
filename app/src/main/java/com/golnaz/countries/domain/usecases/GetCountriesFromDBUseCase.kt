package com.golnaz.countries.domain.usecases

import com.golnaz.countries.domain.model.CountryModel
import com.golnaz.countries.domain.model.CountryRelation
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.FlowUseCaseNotParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

 class GetCountriesFromDBUseCase @Inject constructor(private val countriesRepository: CountriesRepository) :
    FlowUseCaseNotParams<Flow<List<CountryRelation>>>() {
     /*override suspend fun run(): Flow<List<CountryModel>> {
         return countriesRepository.getCountries()
     }*/
      override suspend fun run(): Flow<List<CountryRelation>> {
          return countriesRepository.getAllCountriesFromDB()
      }
     /* override suspend fun executeOnBackground(): Flow<List<CountryRelation>> {
          return countriesRepository.getAllCountriesFromDB()
      }*/
}
