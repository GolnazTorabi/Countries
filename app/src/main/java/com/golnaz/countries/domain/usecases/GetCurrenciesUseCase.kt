package com.golnaz.countries.domain.usecases

import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.domain.model.CurrencyModel
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.FlowUseCaseNotParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(private val countriesRepository: CountriesRepository) :
    FlowUseCaseNotParams<Flow<List<CurrencyModel>>>() {
    override suspend fun run(): Flow<List<CurrencyModel>> {
        return countriesRepository.getCurrencies()
    }
}