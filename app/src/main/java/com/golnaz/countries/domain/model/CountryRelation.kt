package com.golnaz.countries.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class CountryRelation(
    @Embedded val country: CountryModel,
    @Relation(
        parentColumn = "name",
        entityColumn = "countryName",
        entity = CurrencyModel::class
    )
    val currency: MutableList<CurrencyModel>
)
