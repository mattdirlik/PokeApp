package com.example.pokeapp.data

import com.example.pokeapp.data.models.PokemonDetailResponse
import com.example.pokeapp.data.models.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon/")
    suspend fun getAllPokemon(): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int?): PokemonDetailResponse
}