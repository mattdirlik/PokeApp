package com.example.pokeapp.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.pokeapp.data.models.PokemonObject
import com.example.pokeapp.R
import com.example.pokeapp.extensions.getPokemonId

class MainAdapter: RecyclerView.Adapter<MainAdapter.CharacterViewHolder>() {
    private var pokemonList: List<PokemonObject>? = null
    var onItemClick: ((PokemonObject) -> Unit)? = null

    @SuppressLint("notifyDataSetChanged")
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
        pokemon?.url?.getPokemonId()?.let {
            holder.image.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$it.png")
        }

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
        val image: ImageView = itemView.findViewById(R.id.spriteImage)
    }
}