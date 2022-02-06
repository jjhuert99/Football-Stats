package com.example.footballstats.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballstats.databinding.HolderTeamRecordsBinding
import com.example.footballstats.network.TeamRecord

class HomeAdapter: ListAdapter<TeamRecord, HomeAdapter.TeamRecordData>(DiffCallback){

    class TeamRecordData(private var binding: HolderTeamRecordsBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(team: TeamRecord){
            binding.teamRecord = team
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TeamRecord>() {
        override fun areItemsTheSame(oldItem: TeamRecord, newItem: TeamRecord): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TeamRecord, newItem: TeamRecord): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamRecordData {
        return TeamRecordData(HolderTeamRecordsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TeamRecordData, position: Int) {
        val team = getItem(position)
        holder.bind(getItem(position))
        holder.bind(team)
    }
}
