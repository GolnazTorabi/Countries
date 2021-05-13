package com.golnaz.countries.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Country")
data class CountryModel(
    @PrimaryKey(autoGenerate = false)
    val alphaCode: String,
    val name: String? = null,
    val capital: String? = null,
    val language: String? = null,
    val region: String? = null,
    val currency: String? = null,
    val ImageUrl: String? = null,
)
