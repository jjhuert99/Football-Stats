package com.example.footballstats.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballstats.network.ServiceResult
import com.example.footballstats.network.TeamRecord
import com.example.footballstats.network.TeamRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app: Application,
    private val TeamRepo: TeamRepo,
    private val dispatcher: Dispatchers
) : ViewModel() {
    enum class TeamStatus { ERROR, DONE }

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    private val _status = MutableLiveData<TeamStatus>()
    val status: LiveData<TeamStatus> = _status

    private val _post = MutableLiveData<List<TeamRecord>?>()
    val post: LiveData<List<TeamRecord>?> = _post

    var searchYear = MutableLiveData<String?>()

    fun checkDate(date: String?): Boolean{
        if(date?.toInt()!! > 2019 || date?.toInt()!! < 1970){
            return false
        }
        return true
    }

    private fun getTeamRecords() {
        viewModelScope.launch(dispatcher.IO) {
            when (val response = TeamRepo.getTeamRecord(year = "2001")) {
                is ServiceResult.Succes -> {
                    _post.postValue(response.data)
                    _status.postValue(TeamStatus.DONE)
                }
                is ServiceResult.Error -> {
                    _status.postValue(TeamStatus.ERROR)
                }
                else -> {
                    _status.postValue(TeamStatus.ERROR)
                }
            }
        }
    }
}
