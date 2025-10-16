package com.example.mmunozmusicapp.Components

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun HeaderDetail(
    album: Album, modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
    ){
        AsyncImage(model = album.image ?: "",
            contentDescription = album.title ?: "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.3f))
        ) {
            AsyncImage(
                model = album.image ?: "",
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(5.dp)
                )
            Icon(
                imageVector = Icons.Default.FavoriteBorder, contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(5.dp)
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(album.title ?: "",
                    color = Color.Cyan,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold)
                Text(album.artist ?: "",
                    color = Color.Cyan,
                    fontSize = 30.sp)
                Row(){
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = Color.White,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(shape = CircleShape)
                        .background(Purple)
                        .padding(4.dp))

                Spacer(modifier = Modifier.width(10.dp))
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(shape = CircleShape)
                            .background(Color.White)
                            .padding(4.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun HeaderDetailView() {
    val HeaderDetailTest = Album(
        title = "Let It Be",
        artist = "The Beatles",
        description = "El último álbum lanzado por The Beatles, una despedida cargada de emociones.",
        image = "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/ae/98/4c/ae984c7a-cd06-a7cd-e8bf-32cb15ba698d/00602567705475.rgb.jpg/1200x630bf-60.jpg",
        id = "682243ecf60db4caa642a48e"
    )
    MMunozMusicAppTheme {
        HeaderDetail( HeaderDetailTest)
    }
}