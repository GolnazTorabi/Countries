package com.golnaz.countries.app.countyList.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.golnaz.countries.data.local.response.ResponseCountriesItem
import com.golnaz.countries.databinding.CountriesItemBinding
import com.golnaz.countries.domain.model.CountryRelation
import com.golnaz.countries.utils.bindingAdapter.LoadImageUrl
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CountriesListAdapter @Inject constructor() :
    RecyclerView.Adapter<CountriesListAdapter.CountriesViewHolder>() {
    private var countriesList: MutableList<CountryRelation?> = mutableListOf()

    inner class CountriesViewHolder(private val binding: CountriesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: CountryRelation) {
            Log.d("TAG", "setData: ${data.currency}")
            binding.country = data
        }
    }

    private var inflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        if (inflater == null) inflater = LayoutInflater.from(parent.context)
        val binding: CountriesItemBinding = CountriesItemBinding.inflate(inflater!!, parent, false)
        return CountriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        countriesList[position]?.let { holder.setData(it) }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int = countriesList.size

    fun fillData(countriesList: MutableList<CountryRelation?>) {
        this.countriesList.clear()
        this.countriesList = countriesList
        notifyDataSetChanged()
    }
}