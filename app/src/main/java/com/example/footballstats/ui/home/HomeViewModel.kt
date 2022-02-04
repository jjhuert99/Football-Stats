package com.example.footballstats.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.footballstats.network.TeamRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val TeamRepo: TeamRepo,
    private val dispatcher: Dispatchers
): ViewModel() {

}
