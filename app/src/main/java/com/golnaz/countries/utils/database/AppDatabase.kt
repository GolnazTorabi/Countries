package com.golnaz.countries.utils.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.golnaz.countries.domain.model.CountryModel

@Database(entities = [CountryModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
}