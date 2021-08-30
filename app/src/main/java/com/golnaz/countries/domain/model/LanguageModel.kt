package com.golnaz.countries.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Language"
)
data class LanguageModel(
    @PrimaryKey
    val languageName: String,
    val nativeName: String? = null,
    val iso6392: String? = null,
    val iso6391: String? = null
)
