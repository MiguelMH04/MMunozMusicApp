package com.example.mmunozmusicapp.Components

import android.R.attr.fontStyle
import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mmunozmusicapp.Models.Album
import com.example.mmunozmusicapp.ui.theme.MMunozMusicAppTheme

@Composable
fun AlbumColumn(
    album: Album, onClick:()-> Unit
){
    Row (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Blue)
            .padding(10.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            modifier = Modifier.size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        ) {
            Text(album.title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Row(

            ){
            Text(album.artist,
                color = Color.Black,
                fontStyle = FontStyle.Italic)

                Text(" . Popular Song",
                    color = Color.Black,
                    fontStyle = FontStyle.Italic)

            }
        }
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
    }

}


@Preview
@Composable
fun AlbumColumnView() {
    val albumPrueba = Album(
        title = "Let It Be",
        artist = "The Beatles",
        description = "El último álbum lanzado por The Beatles, una despedida cargada de emociones.",
        image = "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/ae/98/4c/ae984c7a-cd06-a7cd-e8bf-32cb15ba698d/00602567705475.rgb.jpg/1200x630bf-60.jpg",
        id = "682243ecf60db4caa642a48e"
    )
    MMunozMusicAppTheme {
    AlbumColumn(album = albumPrueba, onClick = {

    })
    }
}