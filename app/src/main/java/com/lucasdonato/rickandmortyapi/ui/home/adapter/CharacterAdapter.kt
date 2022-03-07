package com.lucasdonato.rickandmortyapi.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lucasdonato.rickandmortyapi.data.model.RickAndMorty
import com.lucasdonato.rickandmortyapi.databinding.ViewCharacterBinding
import com.lucasdonato.rickandmortyapi.ui.home.adapter.CharacterAdapter.ImageViewHolder

class CharacterAdapter(private val onItemClick: ((item: RickAndMorty, index: Int) -> Unit)? = null) :
    PagingDataAdapter<RickAndMorty, ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(val binding: ViewCharacterBinding) : ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickAndMorty>() {
            override fun areItemsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ViewCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val character = getItem(position)
        holder.binding.apply {
            holder.itemView.apply {

                rickAndMorty = character

                lavFavorites.setOnClickListener {
                    lavFavorites.playAnimation()
                    character?.let { result -> onItemClick?.invoke(result, position) }
                }

            }
        }
    }

}
