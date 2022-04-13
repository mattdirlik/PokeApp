package com.example.pokeapp.data

import com.example.pokeapp.data.models.PokemonListResponse

class PokeRepository(private val api: PokeApi) {
    suspend fun getAllPokemon(): PokemonListResponse {
        return api.getAllPokemon()
    }
}