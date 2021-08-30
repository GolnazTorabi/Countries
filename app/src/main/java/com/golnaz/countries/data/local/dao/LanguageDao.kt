package com.golnaz.countries.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.golnaz.countries.domain.model.LanguageModel
import kotlinx.coroutines.flow.Flow

@Dao
interface LanguageDao : BaseDao<LanguageModel> {

  /*  @Query(value = "Delete  From Language")
    suspend fun deleteAllLanguages()*/

    /*@Query(value = "SELECT * FROM Language ORDER BY languageName")
    @Transaction
    suspend fun getAllLanguages(): List<LanguageModel>*/

   /* @Transaction
    open suspend fun updateCountries(countries: List<LanguageModel>) {
        deleteAllLanguages()
        insert(countries)
    }*/
}
