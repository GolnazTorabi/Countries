package com.golnaz.countries.app.countryDetail

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.golnaz.countries.R

class CountriesFragment : Fragment() {

    companion object {
        fun newInstance() = CountriesFragment()
    }

    private lateinit var viewModel: CountriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.countries_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(CountriesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}