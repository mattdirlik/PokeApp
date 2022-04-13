package com.example.pokeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokeapp.data.models.PokemonObject
import com.example.pokeapp.R

class MainAdapter: RecyclerView.Adapter<MainAdapter.CharacterViewHolder>() {
    private var pokemonList: List<PokemonObject>? = null
    var onItemClick: ((PokemonObject) -> Unit)? = null

    fun setData(pokemonList: List<PokemonObject>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return CharacterViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val pokemon = pokemonList?.get(position)
        holder.name.text = pokemon?.name

        holder.itemView.setOnClickListener {
            pokemonList?.let {
                onItemClick?.invoke(it[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return pokemonList?.size ?: 0
    }

    class CharacterViewHolder(v: View): ViewHolder(v) {
        val name: TextView = itemView.findViewById(R.id.nameLabel)
    }
}