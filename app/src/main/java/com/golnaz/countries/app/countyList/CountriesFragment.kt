package com.golnaz.countries.app.countyList

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.golnaz.countries.app.countyList.adapter.CountriesListAdapter
import com.golnaz.countries.databinding.CountriesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CountriesFragment : Fragment() {
    private var _binding: CountriesFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CountriesViewModel by viewModels()

    @Inject
    lateinit var adapter: CountriesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CountriesFragmentBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCountries()
        observeCountries()
        observeErrors()
        initAdapter()
    }

    private fun convertToPx(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics
        )
    }

    private fun initAdapter() {
        binding.countriesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.countriesList.adapter = adapter
    }

    private fun getCountries() {
        viewModel.getCountries()
    }

    private fun observeCountries() {
        viewModel.countries.observe(requireActivity(), { data ->
            Log.d("TAG", "observeCountries: $data")
            data?.toMutableList()?.let { adapter.fillData(it) }
        })
    }

    private fun observeErrors() {
        viewModel.error.observe(requireActivity(), { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
        })
    }


}