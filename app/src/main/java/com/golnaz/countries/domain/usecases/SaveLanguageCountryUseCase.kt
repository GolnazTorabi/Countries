package com.golnaz.countries.domain.usecases

import com.golnaz.countries.domain.model.LanguageCountryCross
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.UseCase
import javax.inject.Inject

class SaveLanguageCountryUseCase @Inject constructor(private val countriesRepository: CountriesRepository) :
    UseCase<Unit, List<LanguageCountryCross>>() {

    override suspend fun run(params: List<LanguageCountryCross>?) {
        if (params != null) {
            countriesRepository.insertLanguageCountry(params)
        }
    }
}