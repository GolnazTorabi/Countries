package com.golnaz.countries.app.countyList

import android.util.Log
import androidx.lifecycle.*
import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.domain.model.*
import com.golnaz.countries.domain.usecases.*
import com.golnaz.countries.utils.coroutinesExt.ApiError
import com.golnaz.countries.utils.coroutinesExt.UseCaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val saveLanguagesToDBUseCase: SaveLanguagesToDBUseCase,
    private val saveCountriesToDBUseCase: SaveCountriesToDBUseCase,
    private val saveLanguageCountryUseCase: SaveLanguageCountryUseCase,
    private val saveCurrenciesToDBUseCase: SaveCurrenciesToDBUseCase,
    private val getCountriesFromDBUseCase: GetCountriesFromDBUseCase
) :
    ViewModel() {

    private var _countries = MutableLiveData<List<CountryRelation?>?>()
    val countries: LiveData<List<CountryRelation?>?> get() = _countries


    val error = MutableLiveData<String?>()

    private var _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> get() = _progress


    fun getCountries() {
        viewModelScope.launch {
            getCountriesFromDBUseCase
                .invoke(
                    viewModelScope, object : UseCaseResponse<Flow<List<CountryRelation>>> {
                        override suspend fun onSuccess(result: Flow<List<CountryRelation>>) {
                            if (result.count() == 0) {
                                getCountriesFromServer()
                            } else {
                                result.collect {
                                    Log.d("TAG", "onSuccess: ${it.size}")
                                    _countries.value = it
                                }
                                _countries.value = result.asLiveData(coroutineContext).value

                            }
                        }

                        override suspend fun onError(apiError: ApiError?) {
                            error.value = apiError?.getErrorMessage()
                        }

                    }
                )
        }
    }

    private suspend fun getCountriesFromServer() {
        _progress.value = true
        getCountriesUseCase.invoke(viewModelScope,
            object : UseCaseResponse<Flow<List<ResponseCountriesItem?>?>> {
                override suspend fun onError(apiError: ApiError?) {
                    _progress.value = false
                    error.value = apiError?.getErrorMessage()
                }

                override suspend fun onSuccess(result: Flow<List<ResponseCountriesItem?>?>) {
                    _progress.value = false
                    onComplete(result)
                }

            })
    }

    private suspend fun onComplete(data: Flow<List<ResponseCountriesItem?>?>) {
        data.collect { value ->
            saveData(value)
            getCountries()
        }
    }


    private fun saveData(value: List<ResponseCountriesItem?>?) {
        saveLanguages(value)
        saveCountries(value)
        saveCountryLanguage(value)
        saveCurrency(value)
    }

    private fun saveCurrency(value: List<ResponseCountriesItem?>?) {
        viewModelScope.launch {
            saveCurrenciesToDBUseCase.run(params = convertToCurrencyModel(value))
        }

    }

    private fun convertToCurrencyModel(value: List<ResponseCountriesItem?>?): MutableList<CurrencyModel> {
        val currenciesList: MutableList<CurrencyModel> = mutableListOf()
        for (i in 0 until value?.size!!) {
            currenciesList.add(
                CurrencyModel(
                    code = value[i]?.currencies?.get(0)?.code.toString(),
                    countryName = value[i]?.name.toString(),
                    symbol = value[i]?.currencies?.get(0)?.symbol.toString(),
                    currencyName = value[i]?.currencies?.get(0)?.name.toString()
                )
            )
        }
        return currenciesList
    }

    private fun saveCountryLanguage(value: List<ResponseCountriesItem?>?) {
        viewModelScope.launch {
            saveLanguageCountryUseCase.run(params = convertToCountryModel(value))
        }


    }

    private fun convertToCountryModel(value: List<ResponseCountriesItem?>?): MutableList<LanguageCountryCross> {
        val languageCountryList: MutableList<LanguageCountryCross> = mutableListOf()
        for (i in 0 until value?.size!!) {
            for (j in 0 until value[i]?.languages?.size!!)
                languageCountryList.add(
                    LanguageCountryCross(
                        value[i]?.languages?.get(j)?.name.toString(),
                        value[i]?.alpha3Code.toString()
                    )
                )
        }
        return languageCountryList
    }

    private fun saveCountries(value: List<ResponseCountriesItem?>?) {
        viewModelScope.launch {
            saveCountriesToDBUseCase.run(params = value)
        }
    }

    private fun saveLanguages(value: List<ResponseCountriesItem?>?) {
        viewModelScope.launch {
            saveLanguagesToDBUseCase.run(params = convertToLanguageModel(value))
        }
    }

    private fun convertToLanguageModel(value: List<ResponseCountriesItem?>?): MutableList<LanguageModel> {
        val languageList: MutableList<LanguageModel> = mutableListOf()
        for (i in 0 until value?.size!!) {
            for (j in 0 until value[i]?.languages?.size!!)
                languageList.add(
                    LanguageModel(
                        value[i]?.languages?.get(j)?.name.toString(),
                        value[i]?.languages?.get(j)?.nativeName,
                        value[i]?.languages?.get(j)?.iso6392,
                        value[i]?.languages?.get(j)?.iso6391
                    )
                )
        }
        return languageList
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}

