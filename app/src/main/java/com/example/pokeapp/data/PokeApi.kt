package com.example.pokeapp.data

import com.example.pokeapp.data.models.PokemonListResponse
import retrofit2.http.GET

interface PokeApi {
    @GET("pokemon/")
    suspend fun getAllPokemon(): PokemonListResponse
}