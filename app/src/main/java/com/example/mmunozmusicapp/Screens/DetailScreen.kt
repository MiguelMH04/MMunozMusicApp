package com.example.mmunozmusicapp.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mmunozmusicapp.Components.AlbumDetail
import com.example.mmunozmusicapp.Components.HeaderDetail
import com.example.mmunozmusicapp.Models.Album
import com.example.mmunozmusicapp.Services.AlbumService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun DetailScreen(id: String){
    var album by remember {
        mutableStateOf<Album?>(null)
    }

    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = withContext(Dispatchers.IO){
                service.getAlbumById(id)
            }
            album = result
            Log.i("DetailScreen", album.toString())
        }
        catch (e : Exception){
            Log.e("DetailScreen", e.toString())
        }
    }
    album?.let{ a ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(  20.dp)
        ) {
            HeaderDetail(album = a )
            AlbumDetail( album = a)
        }

    }

}
