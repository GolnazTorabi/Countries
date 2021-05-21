package com.golnaz.countries.domain

import com.golnaz.countries.data.local.response.ResponseCountries
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.BaseResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(private val countriesRepository: CountriesRepository) {
    fun getCountries(): Flow<BaseResponse<ResponseCountries>> {
        return countriesRepository.getAllCountries()
    }
}