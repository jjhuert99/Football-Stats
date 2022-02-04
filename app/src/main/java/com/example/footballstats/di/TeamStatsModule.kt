package com.example.footballstats.di

import com.example.footballstats.network.RetrofitFactory
import com.example.footballstats.network.TeamEndPoints
import com.example.footballstats.network.TeamRepo
import com.example.footballstats.network.TeamRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object TeamStatsModule {
    private const val BASE_URL = "https://nfl-team-stats.p.rapidapi.com/"

    @Singleton
    @Provides
    fun provideTeamRetrofit(): TeamEndPoints{
        return RetrofitFactory.retrofitProvider(
            TeamEndPoints::class.java,
            BASE_URL
        )
    }

    @Singleton
    @Provides
    fun provideTeamRepo(dispatcher: Dispatchers, retroObject: TeamEndPoints): TeamRepo{
        return TeamRepoImpl(dispatcher, retroObject)
    }
}
