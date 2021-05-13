package com.golnaz.countries.data.local.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCountries(

	@Json(name = "ResponseCountries")
	val responseCountries: List<ResponseCountriesItem?>? = null
) : Parcelable

@Parcelize
data class RegionalBlocsItem(

	@Json(name = "otherNames")
	val otherNames: List<String?>? = null,

	@Json(name = "acronym")
	val acronym: String? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "otherAcronyms")
	val otherAcronyms: List<String?>? = null
) : Parcelable

@Parcelize
data class LanguagesItem(

	@Json(name = "nativeName")
	val nativeName: String? = null,

	@Json(name = "iso639_2")
	val iso6392: String? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "iso639_1")
	val iso6391: String? = null
) : Parcelable

@Parcelize
data class CurrenciesItem(

	@Json(name = "symbol")
	val symbol: String? = null,

	@Json(name = "code")
	val code: String? = null,

	@Json(name = "name")
	val name: String? = null
) : Parcelable

@Parcelize
data class ResponseCountriesItem(

	@Json(name = "area")
	val area: Double? = null,

	@Json(name = "nativeName")
	val nativeName: String? = null,

	@Json(name = "capital")
	val capital: String? = null,

	@Json(name = "demonym")
	val demonym: String? = null,

	@Json(name = "flag")
	val flag: String? = null,

	@Json(name = "alpha2Code")
	val alpha2Code: String? = null,

	@Json(name = "languages")
	val languages: List<LanguagesItem?>? = null,

	@Json(name = "borders")
	val borders: List<String?>? = null,

	@Json(name = "subregion")
	val subregion: String? = null,

	@Json(name = "callingCodes")
	val callingCodes: List<String?>? = null,

	@Json(name = "regionalBlocs")
	val regionalBlocs: List<RegionalBlocsItem?>? = null,

	@Json(name = "gini")
	val gini: Double? = null,

	@Json(name = "population")
	val population: Int? = null,

	@Json(name = "numericCode")
	val numericCode: String? = null,

	@Json(name = "alpha3Code")
	val alpha3Code: String? = null,

	@Json(name = "topLevelDomain")
	val topLevelDomain: List<String?>? = null,

	@Json(name = "timezones")
	val timezones: List<String?>? = null,

	@Json(name = "cioc")
	val cioc: String? = null,

	@Json(name = "translations")
	val translations: Translations? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "altSpellings")
	val altSpellings: List<String?>? = null,

	@Json(name = "region")
	val region: String? = null,

	@Json(name = "latlng")
	val latlng: List<Double?>? = null,

	@Json(name = "currencies")
	val currencies: List<CurrenciesItem?>? = null
) : Parcelable

@Parcelize
data class Translations(

	@Json(name = "br")
	val br: String? = null,

	@Json(name = "de")
	val de: String? = null,

	@Json(name = "pt")
	val pt: String? = null,

	@Json(name = "ja")
	val ja: String? = null,

	@Json(name = "hr")
	val hr: String? = null,

	@Json(name = "it")
	val it: String? = null,

	@Json(name = "fa")
	val fa: String? = null,

	@Json(name = "fr")
	val fr: String? = null,

	@Json(name = "es")
	val es: String? = null,

	@Json(name = "nl")
	val nl: String? = null
) : Parcelable
