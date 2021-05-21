package com.golnaz.countries.domain.repository

import com.golnaz.countries.data.local.response.ResponseCountries
import com.golnaz.countries.utils.BaseResponse
import kotlinx.coroutines.flow.Flow

interface CountriesRepository {
    fun getAllCountries(): Flow<BaseResponse<ResponseCountries>>
}