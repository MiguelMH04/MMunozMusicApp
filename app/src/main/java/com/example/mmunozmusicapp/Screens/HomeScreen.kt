package com.example.mmunozmusicapp.Screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import com.example.mmunozmusicapp.Models.Album
import com.example.mmunozmusicapp.Services.AlbumService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(){
    var Albums by remember{
        mutableStateOf(listOf<Album>())
    }
    var Loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) {
        try {
            Log.i("HomeScreen", "Inicializando")
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = async(Dispatchers.IO) {
                service.getAllAlbums()
            }
            Log.i("HomeScreen","${result.await()}")
            Albums = result.await()
            Loading = false
        }
        catch (e: Exception){
            Loading = false
            Log.e("HomeScreen", e.toString())
        }
    }
    if (Loading ){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        val Album = Albums[0]
        Column (){
            Text(text = "Artista: ${Album.artist}")
            Text(text = "Título: ${Album.title}")
            Text(text = "Descripción: ${Album.description}")
        }
    }

}
