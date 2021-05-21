package com.golnaz.countries.app.countyList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.golnaz.countries.domain.GetCountriesUseCase
import com.golnaz.countries.utils.BaseResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class CountriesViewModel @ViewModelInject constructor(private val getCountriesUseCase: GetCountriesUseCase) :
    ViewModel() {


    fun getCountries() {
        viewModelScope.launch {
            getCountriesUseCase.getCountries().catch { exception ->
                exception.message

            }
                .collect { data ->
                    when (data) {
                        is BaseResponse.Loading -> {
                            //set loading
                        }
                        is BaseResponse.Fail -> {
                            data.error.message
                        }
                        is BaseResponse.Success -> {
                            data.value
                        }
                    }
                }
        }
    }
}