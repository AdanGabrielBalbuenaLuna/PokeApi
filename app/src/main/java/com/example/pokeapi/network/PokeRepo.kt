package com.example.pokeapi.network

import com.example.pokeapi.util.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeRepo() {
    private val instanciaRetrofit by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    //fun getPokemon():Response<>
}