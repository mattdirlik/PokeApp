package com.example.pokeapp.extensions

fun String.getPokemonId(): Int {
    return this.substringBeforeLast('/').substringAfterLast('/').toInt()
}