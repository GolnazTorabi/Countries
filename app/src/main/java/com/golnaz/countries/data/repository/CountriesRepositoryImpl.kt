package com.golnaz.countries.data.repository

import com.golnaz.countries.data.api.CountriesApiImpl
import com.golnaz.countries.data.local.response.ResponseCountries
import com.golnaz.countries.domain.repository.CountriesRepository
import com.golnaz.countries.utils.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(private val countriesApiImpl: CountriesApiImpl) :
    CountriesRepository {
    override fun getAllCountries(): Flow<BaseResponse<ResponseCountries>> = flow {
        emit(BaseResponse.Loading)
        val response = try {
            val result = countriesApiImpl.getAllCountries()
            BaseResponse.Success(result)
        } catch (t: Throwable) {
            BaseResponse.Fail(t)
        }
        emit(response)
    }

}