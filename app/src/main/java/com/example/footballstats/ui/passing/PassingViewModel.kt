package com.example.footballstats.ui.passing

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.footballstats.network.TeamRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PassingViewModel @Inject constructor(
    private val app: Application,
    private val TeamRepo: TeamRepo,
    private val dispatcher: Dispatchers
) : ViewModel() {
    var searchYear = MutableLiveData<String>()
}
