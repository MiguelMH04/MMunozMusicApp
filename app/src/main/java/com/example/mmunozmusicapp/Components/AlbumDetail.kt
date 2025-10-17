package com.example.mmunozmusicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mmunozmusicapp.Models.Album
import com.example.mmunozmusicapp.ui.theme.MMunozMusicAppTheme

@Composable
fun AlbumDetail(
    album: Album
){
    Column(
        modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxWidth()
            .height(250.dp)
    ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .shadow(20.dp, RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(10.dp)

            ) {
                Text(
                    "About this album",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier
                    .height(13.dp))
                Text(
                    album.description ?: "",
                    fontSize = 20.sp
                )
            }
        Spacer(modifier = Modifier
            .height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(.7f)
                .padding(10.dp)
                .shadow(20.dp, RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White)
                .padding(10.dp)
        ) {
            Text(
                "Artist:",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier
                .width(13.dp))
            Text(
                album.artist ?: "",
                fontSize = 20.sp
            )
        }
        }

    }

@Preview
@Composable
fun AlbumDetailView() {
    val AlbumDetailTest = Album(
        title = "Let It Be",
        artist = "The Beatles",
        description = "El último álbum lanzado por The Beatles, una despedida cargada de emociones.",
        image = "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/ae/98/4c/ae984c7a-cd06-a7cd-e8bf-32cb15ba698d/00602567705475.rgb.jpg/1200x630bf-60.jpg",
        id = "682243ecf60db4caa642a48e"
    )
    MMunozMusicAppTheme {
        AlbumDetail( AlbumDetailTest)
    }
}