package com.example.footballstats.network

class TeamRecord(
    val name: String,
    val wins: Int,
    val losses: Int
)

class TeamRushing(
    val name: String,
    val yards: Int,
    val touchdowns: Int
)

class TeamPassing(
    val name: String,
    val passYards: Int,
    val completions: Int,
    val touchdowns: Int
    )
