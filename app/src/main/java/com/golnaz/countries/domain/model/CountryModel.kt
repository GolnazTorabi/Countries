package com.golnaz.countries.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "Country"
)
data class CountryModel(
    @PrimaryKey
    val name: String,
    val alpha3Code: String,
    val alphaCode: String,
    val capital: String? = null,
    val imageUrl: String? = null,
)
