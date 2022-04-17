package com.example.pokeapp.data

import com.example.pokeapp.data.models.PokemonDetailResponse
import com.example.pokeapp.data.models.PokemonListResponse

class PokeRepository(private val api: PokeApi) {
    suspend fun getAllPokemon(): PokemonListResponse {
        return api.getAllPokemon()
    }

    suspend fun getPokemonDetail(id: Int): PokemonDetailResponse {
        return api.getPokemonDetail(id)
    }
}