package com.example.pokeapi.network

import retrofit2.http.GET

interface EndPoint {
    @GET("/resto/")
    fun getPokemon(): Call
}