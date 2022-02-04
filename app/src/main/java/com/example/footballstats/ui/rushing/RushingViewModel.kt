package com.example.footballstats.ui.rushing

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.footballstats.network.TeamRepo
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RushingViewModel @Inject constructor(
    private val app: Application,
    private val TeamRepo: TeamRepo,
    private val dispatcher: Dispatchers
): ViewModel() {
    // TODO: Implement the ViewModel
}
