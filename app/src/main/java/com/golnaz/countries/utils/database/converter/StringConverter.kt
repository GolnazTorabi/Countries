package com.golnaz.countries.utils.database.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.ParameterizedType

object StringConverter {
    @TypeConverter
    @JvmStatic
    fun fromString(value: String): List<String> {
        val type: ParameterizedType =
            Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.fromJson(value).orEmpty()
    }

    @TypeConverter
    @JvmStatic
    fun fromList(value: List<String>): String {
        return Moshi.Builder().build().adapter<List<String>>(String::class.java).toJson(value)
    }
}