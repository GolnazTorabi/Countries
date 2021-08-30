package com.golnaz.countries.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.golnaz.countries.domain.model.CountryModel
import com.golnaz.countries.domain.model.CountryRelation

@Dao
interface CountriesDao : BaseDao<CountryModel> {

   /* @Query(value = "Delete From Country")
    suspend fun deleteAllCountries()*/

    @Transaction
    @Query(value = "SELECT * FROM Country")
    fun getAllCountries(): List<CountryRelation>
    @Query(value = "SELECT * FROM Country")
    fun getAllCountriess(): List<CountryModel>

   /* @Transaction
    open suspend fun updateCountries(countries: List<CountryModel>) {
        deleteAllCountries()
        insert(countries)
    }*/
}