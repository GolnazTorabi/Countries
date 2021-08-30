package com.golnaz.countries.domain.usecases

import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.domain.model.CountryModel
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.FlowUseCaseNotParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(private val countriesRepository: CountriesRepository) :
    FlowUseCaseNotParams<Flow<List<CountryModel>>>() {
    override suspend fun run(): Flow<List<CountryModel>> {
        return countriesRepository.getCountries()
    }
}