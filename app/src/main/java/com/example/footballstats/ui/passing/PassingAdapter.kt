package com.example.footballstats.ui.passing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballstats.databinding.HolderPassingDataBinding
import com.example.footballstats.network.TeamPassing

class PassingAdapter : ListAdapter<TeamPassing, PassingAdapter.TeamPassingData>(DiffCallback){

    class TeamPassingData(private var binding: HolderPassingDataBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(team: TeamPassing){
            binding.teamPassing = team
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TeamPassing>() {
        override fun areItemsTheSame(oldItem: TeamPassing, newItem: TeamPassing): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TeamPassing, newItem: TeamPassing): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamPassingData {
        return TeamPassingData(HolderPassingDataBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TeamPassingData, position: Int) {
        val team = getItem(position)
        holder.bind(getItem(position))
        holder.bind(team)
    }
}
