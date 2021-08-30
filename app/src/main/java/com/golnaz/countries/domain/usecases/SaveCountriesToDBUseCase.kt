package com.golnaz.countries.domain.usecases

import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.domain.model.mapper.CountryToDBMapper
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.coroutinesExt.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveCountriesToDBUseCase @Inject constructor(private val countriesRepository: CountriesRepository) :
    UseCase<Unit, List<ResponseCountriesItem?>?>() {

    override suspend fun run(params: List<ResponseCountriesItem?>?) {
        val countries = CountryToDBMapper().reverseMap(params)
        countriesRepository.saveToDB(countries)
    }
}