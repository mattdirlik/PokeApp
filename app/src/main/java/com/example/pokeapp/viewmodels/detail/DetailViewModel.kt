package com.example.pokeapp.viewmodels.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.data.PokeRepository
import com.example.pokeapp.data.models.PokemonDetailResponse
import com.example.pokeapp.data.models.PokemonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailViewModel(private val repository: PokeRepository) : ViewModel() {
    private val _pokemonDetail = MutableLiveData<PokemonDetailResponse>()
    var pokemonDetail: LiveData<PokemonDetailResponse> = _pokemonDetail

    fun getPokemonDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getPokemonDetail(id)
                _pokemonDetail.postValue(response)
            } catch (e: Exception) {

            }
        }
    }

}