package com.golnaz.countries.domain.usecases

import com.golnaz.countries.domain.model.LanguageModel
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLanguagesFromDB @Inject constructor(private val countriesRepository: CountriesRepository){ /*:
    UseCase<Flow<List<LanguageModel>>, String>() {*/
    /*override suspend fun executeOnBackground(params: String): Flow<List<LanguageModel>> {
        return countriesRepository.getLanguages(params)
    }*/

    /*override suspend fun run(params: String?): Flow<List<LanguageModel>> {
        return countriesRepository.getLanguages(params!!)
    }*/
}