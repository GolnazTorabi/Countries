package com.golnaz.countries.domain.usecases

import com.golnaz.countries.domain.model.CurrencyModel
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.UseCase
import javax.inject.Inject

class SaveCurrenciesToDBUseCase @Inject constructor(private val countriesRepository: CountriesRepository) :
    UseCase<Unit, List<CurrencyModel>>() {
    /*override suspend fun executeOnBackground(params: List<CurrencyModel>) {
        countriesRepository.saveCurrenciesToDB(params)
    }*/

    override suspend fun run(params: List<CurrencyModel>?) {
        if (params != null) {
            countriesRepository.saveCurrenciesToDB(params)
        }
    }
}