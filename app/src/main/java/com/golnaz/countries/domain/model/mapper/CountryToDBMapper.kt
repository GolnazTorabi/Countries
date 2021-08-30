package com.golnaz.countries.domain.model.mapper

import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.domain.model.CountryModel
import com.golnaz.countries.utils.database.mapper.Mapper

class CountryToDBMapper : Mapper<CountryModel, ResponseCountriesItem>() {
    override fun map(value: CountryModel?): ResponseCountriesItem {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: ResponseCountriesItem?): CountryModel? {
        return if (value == null) {
            null
        } else {
            CountryModel(
                alpha3Code = value.alpha3Code.toString(),
                alphaCode = value.alpha2Code ?: "",
                name = value.name.toString(),
                capital = value.capital,
                imageUrl = value.flag
            )
        }
    }
}