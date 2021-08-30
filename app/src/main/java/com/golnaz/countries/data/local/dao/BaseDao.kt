package com.golnaz.countries.data.local.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg ts: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ts: List<T>)

    @Delete
    fun delete(type: T)

    @Delete
    fun delete(type: List<T>)

    @Update
    fun update(type: T)

    @Update
    fun update(type: List<T>)

}