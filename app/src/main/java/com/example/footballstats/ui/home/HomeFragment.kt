package com.example.footballstats.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.footballstats.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = HomeFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.teamsRecordRV.adapter = HomeAdapter()
        binding.enterButton.setOnClickListener{
            if(viewModel.searchYear.value.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Enter a Date between 1970 and 2019",Toast.LENGTH_LONG).show()
            }
            else if(viewModel.checkDate(viewModel.searchYear.value)){
                Toast.makeText(requireContext(), "Year is ${viewModel.searchYear.value}",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(requireContext(), "Enter a Date between 1970 and 2019",Toast.LENGTH_LONG).show()

            }
        }

        return binding.root
    }


}
