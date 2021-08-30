package com.golnaz.countries.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.golnaz.countries.domain.model.CurrencyModel

@Dao
interface CurrencyDao : BaseDao<CurrencyModel> {

   /* @Query(value = "Delete  From Currency")
    suspend fun deleteAllCurrency()



    @Transaction
    open suspend fun updateCountries(countries: List<CurrencyModel>) {
        deleteAllCurrency()
        insert(countries)
    }*/
   @Query(value = "SELECT * FROM Currency")
   fun getAllCurrency(): List<CurrencyModel>
}
