package com.example.footballstats.network

interface TeamRepo {
    suspend fun getTeamRecord(): ServiceResult<List<TeamRecord>>
    suspend fun getTeamPassing(): ServiceResult<List<TeamPassing>>
    suspend fun getTeamRushing(): ServiceResult<List<TeamRushing>>

}
