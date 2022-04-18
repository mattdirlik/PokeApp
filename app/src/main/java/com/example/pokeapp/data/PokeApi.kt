package com.example.pokeapp.data

import com.example.pokeapp.data.models.PokemonDetailResponse
import com.example.pokeapp.data.models.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon/?limit=100000&offset=0")
    suspend fun getAllPokemon(): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int?): PokemonDetailResponse
}