package com.example.footballstats.ui.rushing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.footballstats.databinding.RushingFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RushingFragment : Fragment() {

    val viewModel: RushingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = RushingFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.teamRushingRV.adapter = RushingAdapter()
        binding.enterButton.setOnClickListener{
            if(viewModel.searchYear.value.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Enter a Date between 1970 and 2019",Toast.LENGTH_LONG).show()
            }
            else if(viewModel.checkDate(viewModel.searchYear.value)){
                viewModel.getTeamRushing(viewModel.searchYear.value.toString())

            }else{
                Toast.makeText(requireContext(), "Enter a Date between 1970 and 2019",Toast.LENGTH_LONG).show()

            }
        }
        return binding.root
    }

}
