package com.example.pokeapi

import retrofit2.Response
import retrofit2.http.GET

interface PokemonApiService {

    @GET("api/v2/pokemon")
    suspend fun getPokemonRoot(): Response<PokemonAllResultsDto>
}