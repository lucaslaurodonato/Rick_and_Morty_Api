package com.lucasdonato.rickandmortyapi.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lucasdonato.rickandmortyapi.R
import com.lucasdonato.rickandmortyapi.data.model.RickAndMortyEntity
import com.lucasdonato.rickandmortyapi.databinding.ViewCharacterBinding
import com.lucasdonato.rickandmortyapi.databinding.ViewCharacterFavoritesBinding
import com.lucasdonato.rickandmortyapi.ui.home.adapter.CharacterAdapter

class FavoritesCharactersAdapter(
    private val items: MutableList<RickAndMortyEntity>,
    private val onItemClick: ((item: RickAndMortyEntity, index: Int) -> Unit)? = null
) : RecyclerView.Adapter<FavoritesCharactersAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewCharacterFavoritesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    private fun deleteItem(p: Int) {
        items.removeAt(p)
        notifyItemRemoved(p)
        notifyItemRangeChanged(p, itemCount)
    }

    inner class ViewHolder(var binding: ViewCharacterFavoritesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favorites = items[position]
        holder.binding.apply {
            rickAndMorty = favorites

            ivExclude.setOnClickListener {
                deleteItem(position)
                favorites.let { result -> onItemClick?.invoke(result, position) }
            }
        }
    }

}

