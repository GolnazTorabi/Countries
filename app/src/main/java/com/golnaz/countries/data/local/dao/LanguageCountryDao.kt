package com.golnaz.countries.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.golnaz.countries.domain.model.LanguageCountryCross

@Dao
interface LanguageCountryDao : BaseDao<LanguageCountryCross> {

    /*@Query("SELECT * FROM languageCountryCross WHERE name= :country")
    @Transaction
    suspend fun getLanguageCountry(country: String): List<LanguageCountryCross>*/
}