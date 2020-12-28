package com.celaloglu.zafer.features.repos;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.celaloglu.zafer.databinding.ItemRepoBinding
import com.celaloglu.zafer.models.ReposItem
import kotlinx.android.synthetic.main.item_repo.view.*

class ReposAdapter(val onClick: (ReposItem, View) -> Unit) :
    ListAdapter<ReposItem, ReposAdapter.RepoViewHolder>(ReposDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return RepoViewHolder(
            ItemRepoBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    inner class RepoViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: ReposItem) {
            with(binding) {
                item = repo
                executePendingBindings()

                root.container.setOnClickListener {
                    onClick(repo, it)
                }
            }
        }
    }

    companion object {
        val ReposDiffUtil =
            object : DiffUtil.ItemCallback<ReposItem>() {
                override fun areItemsTheSame(
                    oldItem: ReposItem,
                    newItem: ReposItem
                ): Boolean = oldItem.githubId == newItem.githubId

                override fun areContentsTheSame(
                    oldItem: ReposItem,
                    newItem: ReposItem
                ): Boolean = oldItem == newItem

            }
    }
}