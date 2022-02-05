package com.example.footballstats.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamRepoImpl @Inject constructor(
    private val dispatcher: Dispatchers,
    private val retroObject: TeamEndPoints
) : TeamRepo {

    override suspend fun getTeamRecord(year: String)
            : ServiceResult<List<TeamRecord>?> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getTeamRecord(year = year)
            if (dataResponse.isSuccessful) {
                ServiceResult.Succes(dataResponse.body())
            } else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }

    override suspend fun getTeamPassing(year: String): ServiceResult<List<TeamPassing>?> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getTeamPassing(year = year)
            if (dataResponse.isSuccessful) {
                ServiceResult.Succes(dataResponse.body())
            } else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }

    override suspend fun getTeamRushing(year: String): ServiceResult<List<TeamRushing>?> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getTeamRushing(year = year)
            if (dataResponse.isSuccessful) {
                ServiceResult.Succes(dataResponse.body())
            } else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }
}
