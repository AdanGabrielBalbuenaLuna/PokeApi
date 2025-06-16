package com.example.pokeapi

import com.google.gson.annotations.SerializedName

data class PokemonAllResultsDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val pokemonDto: List<PokemonDto>
)

