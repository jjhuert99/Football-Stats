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
        binding.enterButton.setOnClickListener{
            Toast.makeText(requireContext(), "Year is ${viewModel.searchYear.value}", Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

}
