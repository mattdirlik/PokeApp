package com.example.pokeapp.data.models

data class PokemonListResponse (
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonObject>? = null
        )