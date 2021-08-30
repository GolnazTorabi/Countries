package com.golnaz.countries.domain.model

import androidx.room.Entity

@Entity(
    tableName = "languageCountryCross", primaryKeys = ["languageName", "name"]
)
data class LanguageCountryCross(
    val languageName: String,
    val name: String
)
