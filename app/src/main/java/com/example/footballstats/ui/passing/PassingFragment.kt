package com.example.footballstats.ui.passing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.footballstats.databinding.PassingFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PassingFragment : Fragment() {

    val viewModel: PassingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = PassingFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.teamPassingdRV.adapter = PassingAdapter()

        binding.enterButton.setOnClickListener{
            if(viewModel.searchYear.value.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Enter a Date between 1970 and 2019",Toast.LENGTH_LONG).show()
            }
            else if(viewModel.checkDate(viewModel.searchYear.value)){
                viewModel.getTeamPassing(viewModel.searchYear.value.toString())

            }else{
                Toast.makeText(requireContext(), "Enter a Date between 1970 and 2019",Toast.LENGTH_LONG).show()

            }
        }
        return binding.root
    }

}
