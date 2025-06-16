package com.example.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pokeapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPokemonRoot()
    }

    //Instancia del objeto retrofit
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Linkear el objeto retrofit con la interfaz
    val call = getRetrofit().create(PokemonApiService::class.java)

    private fun getPokemonRoot(){
        //Crear la corutina
        CoroutineScope(Dispatchers.IO).launch {
            val response = call.getPokemonRoot()
            runOnUiThread{
                if(response.isSuccessful){
                    binding.tvHello.text = response.body()?.pokemonDto.toString()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError(){
        Toast.makeText(this, "An error happened", Toast.LENGTH_SHORT).show()
    }
}