package com.example.mmunozmusicapp.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mmunozmusicapp.Components.AlbumColumn
import com.example.mmunozmusicapp.Components.AlbumHorizontal
import com.example.mmunozmusicapp.Components.Header
import com.example.mmunozmusicapp.Models.Album
import com.example.mmunozmusicapp.Services.AlbumService
import com.example.mmunozmusicapp.ui.theme.LightPurple
import com.example.mmunozmusicapp.ui.theme.Purple
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
                .padding(15.dp)
        ) {
            Header()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text("Albums",
                    fontWeight = FontWeight.Bold)
                Text("See more",
                    color = Purple
                )
            }
            LazyRow(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(Albums){ album ->
                    AlbumHorizontal(
                        album = album,
                        onClick = {}
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text("Recently Played",
                    fontWeight = FontWeight.Bold
                )
                Text("See more",
                    color = Purple
                )
            }
            LazyColumn(
                modifier = Modifier
                    .padding(10.dp),
            ) {
                items(Albums){ album ->
                    AlbumColumn(
                        album = album,
                        onClick = {}
                    )
                }
            }
        }
    }
}
