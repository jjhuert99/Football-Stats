package com.example.footballstats.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface TeamEndPoints {

    @GET("v1/nfl-stats/teams/win-stats/{year}")
    suspend fun getTeamRecord(
        @Header("x-rapidapi-host") host: String = "nfl-team-stats.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "4093b899f7mshd9a518c450bf536p18434ajsn27101561a8ee",
        @Path("year") year: String
    ): Response<List<TeamRecord>?>

    @GET("v1/nfl-stats/teams/passing-stats/offense/{year}")
    suspend fun getTeamPassing(
        @Header("x-rapidapi-host") host: String = "nfl-team-stats.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "4093b899f7mshd9a518c450bf536p18434ajsn27101561a8ee",
        @Path("year") year: String
    ): Response<List<TeamPassing>?>

    @GET("v1/nfl-stats/teams/rushing-stats/offense/{year}")
    suspend fun getTeamRushing(
        @Header("x-rapidapi-host") host: String = "nfl-team-stats.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "4093b899f7mshd9a518c450bf536p18434ajsn27101561a8ee",
        @Path("year") year: String
    ): Response<List<TeamRushing>?>
}
