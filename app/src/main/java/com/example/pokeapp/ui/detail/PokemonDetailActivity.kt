package com.example.pokeapp.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.pokeapp.R
import com.example.pokeapp.constants.NameConstants
import com.example.pokeapp.extensions.getPokemonId
import com.example.pokeapp.viewmodels.detail.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailActivity: AppCompatActivity() {
    private val viewModel by viewModel<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_detail_activity)

        val nameLabel = findViewById<TextView>(R.id.pokemonNameLabel)
        val hpBar = findViewById<ProgressBar>(R.id.hpBar)
        val attackBar = findViewById<ProgressBar>(R.id.atkBar)
        val defBar = findViewById<ProgressBar>(R.id.defBar)
        val sprite = findViewById<ImageView>(R.id.pokemonSpriteImage)
        val typeOne = findViewById<TextView>(R.id.typeOneLabel)
        val typeTwo = findViewById<TextView>(R.id.typeTwoLabel)

        val bundle = intent.extras
        bundle?.getString(NameConstants.POKEMON_URL)?.getPokemonId()?.let {
            viewModel.getPokemonDetail(it)
            sprite.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$it.png")
        }

        viewModel.pokemonDetail.observe(this) { pokemon ->
            hpBar.progress = pokemon.stats[0].base_stat
            attackBar.progress = pokemon.stats[1].base_stat
            defBar.progress = pokemon.stats[2].base_stat
            typeOne.text = pokemon.types[0].type.name
            typeTwo.text = pokemon.types.getOrNull(1)?.type?.name
        }

        nameLabel.text = bundle?.getString(NameConstants.POKEMON_NAME)

    }
}