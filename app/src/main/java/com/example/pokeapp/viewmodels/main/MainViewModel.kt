package com.example.pokeapp.viewmodels.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.data.PokeRepository
import com.example.pokeapp.data.models.PokemonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: PokeRepository) : ViewModel() {
    private val _pokemonList = MutableLiveData<List<PokemonObject>>()
    var pokemonList: LiveData<List<PokemonObject>> = _pokemonList


    fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getAllPokemon()
                _pokemonList.postValue(response.results)
            } catch (e: Exception) {

            }
        }
    }
}