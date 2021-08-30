package com.golnaz.countries.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Currency",
    foreignKeys = [
        ForeignKey(
            entity = CountryModel::class,
            parentColumns = arrayOf("name"),
            childColumns = arrayOf("countryName"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class CurrencyModel(
    @PrimaryKey
    val code: String,
    val countryName: String,
    val symbol: String? = null,
    val currencyName: String? = null
)
