package com.example.footballstats.network

interface TeamRepo {
    suspend fun getTeamRecord(year: String): ServiceResult<List<TeamRecord?>?>
    suspend fun getTeamPassing(year: String): ServiceResult<List<TeamPassing?>?>
    suspend fun getTeamRushing(year: String): ServiceResult<List<TeamRushing?>?>

}
