package com.lucasdonato.rickandmortyapi.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.data.model.RickMorty
import com.lucasdonato.rickandmortyapi.databinding.ViewCharacterBinding
import com.lucasdonato.rickandmortyapi.ui.home.adapter.CharacterAdapter.ImageViewHolder
import com.lucasdonato.rickandmortyapi.utils.constants.Constants.ALIVE
import com.lucasdonato.rickandmortyapi.utils.constants.Constants.DEAD
import com.lucasdonato.rickandmortyapi.utils.constants.Constants.UNKNOWN
import com.lucasdonato.rickandmortyapi.utils.extensions.setTint

class CharacterAdapter(private val onItemClick: ((item: RickMorty, index: Int) -> Unit)? = null) :
    PagingDataAdapter<RickMorty, ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(val binding: ViewCharacterBinding) : ViewHolder(binding.root)

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

                cvContainer.setOnClickListener {
                    character?.let { result -> onItemClick?.invoke(result, position) }
                }

//                ivPicture.load(character?.image) {
//                    crossfade(true)
//                    crossfade(1000)
//                }
            }
        }
    }

}
