package com.example.mmunozmusicapp.Services

import com.example.mmunozmusicapp.Models.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

        @GET("albums")
        suspend fun getAllAlbums() : List<Album>

        @GET("albums/{id}")
        suspend fun getAlbumById(@Path("id") id: String) : Album
    }
