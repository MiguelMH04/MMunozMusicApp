package com.example.mmunozmusicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mmunozmusicapp.Models.Album
import com.example.mmunozmusicapp.ui.theme.LightPurple
import com.example.mmunozmusicapp.ui.theme.MMunozMusicAppTheme
import com.example.mmunozmusicapp.ui.theme.Purple

@Composable
fun AlbumHorizontal(
    album: Album, onClick:()-> Unit
){
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(25.dp))
            .clickable{onClick()}
    ){
        AsyncImage(model = album.image,
            contentDescription = album.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.3f))
        ) {
            AsyncImage(
                model = album.image,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(LightPurple.copy(0.3f))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(album.title,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)
                Text(album.artist,
                    color = Color.White,
                    fontSize = 12.sp)
            }
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(Color.White))

        }
    }
}


@Preview
@Composable
fun AlbumHorizontalView() {
    val albumPrueba = Album(
        title = "Let It Be",
        artist = "The Beatles",
        description = "El último álbum lanzado por The Beatles, una despedida cargada de emociones.",
        image = "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/ae/98/4c/ae984c7a-cd06-a7cd-e8bf-32cb15ba698d/00602567705475.rgb.jpg/1200x630bf-60.jpg",
        id = "682243ecf60db4caa642a48e"
    )
    MMunozMusicAppTheme {
        AlbumHorizontal(album = albumPrueba, onClick = {

        })
    }
}