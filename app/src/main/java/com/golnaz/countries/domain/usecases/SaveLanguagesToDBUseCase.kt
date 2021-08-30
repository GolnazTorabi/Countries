package com.golnaz.countries.domain.usecases

import com.golnaz.countries.domain.model.LanguageModel
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.UseCase
import javax.inject.Inject

class SaveLanguagesToDBUseCase @Inject constructor(private val countriesRepository: CountriesRepository) :
    UseCase<Unit, List<LanguageModel>>() {

    override suspend fun run(params: List<LanguageModel>?) {
        return countriesRepository.saveLanguagesToDB(params)
    }


}