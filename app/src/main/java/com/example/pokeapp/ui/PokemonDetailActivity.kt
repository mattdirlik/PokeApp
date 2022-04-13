package com.example.pokeapp.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokeapp.R
import com.example.pokeapp.constants.NameConstants

class PokemonDetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_detail_activity)

        val bundle = intent.extras


        val nameLabel = findViewById<TextView>(R.id.pokemonNameLabel)

        nameLabel.text = bundle?.getString(NameConstants.POKEMON_NAME)
    }
}