package com.example.footballstats

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballstats.network.TeamPassing
import com.example.footballstats.network.TeamRecord
import com.example.footballstats.network.TeamRushing
import com.example.footballstats.ui.home.HomeAdapter
import com.example.footballstats.ui.passing.PassingAdapter
import com.example.footballstats.ui.rushing.RushingAdapter

@BindingAdapter("teamRecords")
fun bindTeamRecords(recyclerView: RecyclerView, data: List<TeamRecord>?){
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(data)
}

@BindingAdapter("teamPassing")
fun bindTeamPassing(recyclerView: RecyclerView, data: List<TeamPassing>?){
    val adapter = recyclerView.adapter as PassingAdapter
    adapter.submitList(data)
}

@BindingAdapter("teamRushing")
fun bindTeamRushing(recyclerView: RecyclerView, data: List<TeamRushing>?){
    val adapter = recyclerView.adapter as RushingAdapter
    adapter.submitList(data)
}
