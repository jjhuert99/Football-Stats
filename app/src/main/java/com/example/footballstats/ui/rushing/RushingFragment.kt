package com.example.footballstats.ui.rushing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }

}
