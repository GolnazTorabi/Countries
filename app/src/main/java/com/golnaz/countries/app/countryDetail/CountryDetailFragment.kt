package com.golnaz.countries.app.countryDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.golnaz.countries.R

class CountryDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CountryDetailFragment()
    }

    private lateinit var viewModel: CountryDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.country_detail_fragment, container, false)
    }



}