package com.example.footballstats.ui.rushing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballstats.databinding.HolderRushingStatsBinding
import com.example.footballstats.network.TeamRushing

class RushingAdapter : ListAdapter<TeamRushing, RushingAdapter.TeamRushingData>(DiffCallback){

    class TeamRushingData(private var binding: HolderRushingStatsBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(team: TeamRushing){
            binding.teamRushing = team
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TeamRushing>() {
        override fun areItemsTheSame(oldItem: TeamRushing, newItem: TeamRushing): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TeamRushing, newItem: TeamRushing): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamRushingData {
        return TeamRushingData(HolderRushingStatsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TeamRushingData, position: Int) {
        val team = getItem(position)
        holder.bind(getItem(position))
        holder.bind(team)
    }
}
