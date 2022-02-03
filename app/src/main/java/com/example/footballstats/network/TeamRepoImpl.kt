package com.example.footballstats.network

import kotlinx.coroutines.withContext

class TeamRepoImpl : TeamRepo {

    override suspend fun getTeamRecord()
            : ServiceResult<List<TeamRecord>> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getTeamRecord()
            if (dataResponse.isSuccesful) {
                ServiceResult.Succes(dataResponse.body())
            } else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }


    override suspend fun getTeamPassing(): ServiceResult<List<TeamPassing>> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getTeamPassing()
            if (dataResponse.isSuccesful) {
                ServiceResult.Succes(dataResponse.body())
            } else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }


    override suspend fun getTeamRushing(): ServiceResult<List<TeamRushing>> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getTeamRushing()
            if (dataResponse.isSuccesful) {
                ServiceResult.Succes(dataResponse.body())
            } else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }
}
