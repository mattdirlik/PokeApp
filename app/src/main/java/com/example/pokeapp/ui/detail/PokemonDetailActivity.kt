package com.example.pokeapp.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.pokeapp.R
import com.example.pokeapp.constants.NameConstants
import com.example.pokeapp.viewmodels.detail.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailActivity: AppCompatActivity() {
    private val viewModel by viewModel<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_detail_activity)

        val nameLabel = findViewById<TextView>(R.id.pokemonNameLabel)
        val spriteImage = findViewById<ImageView>(R.id.pokemonSpriteImage)

        val bundle = intent.extras
        bundle?.getString(NameConstants.POKEMON_URL)?.substringBeforeLast('/')?.substringAfterLast('/')?.toInt()?.let {
            viewModel.getPokemonDetail(it)
        }

        viewModel.pokemonDetail.observe(this) {
            spriteImage.load(it.sprites.other.officialArtwork.front_default)
        }

        nameLabel.text = bundle?.getString(NameConstants.POKEMON_NAME)

    }
}