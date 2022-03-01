package com.lucasdonato.rickandmortyapi.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.lucasdonato.rickandmortyapi.ui.home.adapter.CharacterAdapter.ImageViewHolder
import com.lucasdonato.rickandmortyapi.data.model.RickMorty
import com.lucasdonato.rickandmortyapi.databinding.CharacterLayoutBinding

class CharacterAdapter : PagingDataAdapter<RickMorty, ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(val binding: CharacterLayoutBinding) : ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            CharacterLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val character = getItem(position)
        holder.binding.apply {
            holder.itemView.apply {

                tvName.text = character?.name

                ivPicture.load(character?.image) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }
    }

}