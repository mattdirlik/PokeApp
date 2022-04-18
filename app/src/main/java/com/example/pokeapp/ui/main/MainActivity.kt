package com.example.pokeapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.viewmodels.main.MainViewModel
import com.example.pokeapp.R
import com.example.pokeapp.constants.NameConstants
import com.example.pokeapp.ui.detail.PokemonDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()

    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPokemonList()
        prepareRecyclerView()
        setObservers()
    }

    private fun setObservers() {
        viewModel.pokemonList.observe(this) {
            adapter.setData(it)
        }
    }

    private fun prepareRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.textBox)
        adapter = MainAdapter()
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val bundle = Bundle().apply {
                putString(NameConstants.POKEMON_NAME, it.name)
                putString(NameConstants.POKEMON_URL, it.url)
            }

            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}