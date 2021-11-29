package com.example.composesampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composesampleproject.ui.theme.ComposeSampleProjectTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MediaList()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun MediaList() {
    LazyVerticalGrid (
        contentPadding = PaddingValues(2.dp),
        //verticalArrangement = Arrangement.spacedBy(4.dp)  <-- Esto si uso LazyColumn y lo de debajo lo quitaría (cells)
        cells = GridCells.Adaptive(150.dp)
    ) {
        items(getMedia()) { item ->
            MediaListItem(item, Modifier.padding(2.dp))
        }
    }
}

@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column {
        Box(
            modifier = modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = item.thumb,
                    /* Esto de debajo por si quiero darle forma redonda a la foto y efecto de fading
                    builder = {
                        transformations(CircleCropTransformation())
                        crossfade(true)
                    }*/
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            if (item.type == MediaItem.Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier
                        .size(92.dp)
                        .align(Center),
                    tint = Color.White
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6.copy(
                    shadow = Shadow(
                        offset = Offset(8f,8f),
                        blurRadius = 12f,
                        color = Color.Black.copy(alpha = 0.6f)
                    )
                )
            )
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true, name = "Android Greeting")
@Composable
fun DefaultPreview() {
    ComposeSampleProjectTheme {
        Greeting("Android")
    }
}

/* @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeFirstProjectTheme {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text (
                    text = "Hello World",
                    fontSize = 50.sp,
                    style = MaterialTheme.typography.h3.copy(
                        shadow = Shadow(
                            offset = Offset(8f,8f),
                            blurRadius = 12f,
                            color = Color.Black.copy(alpha = 0.6f)
                        )
                    ),
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .border(2.dp, Color.Cyan)
                        .background(color = colorResource(R.color.lightBlue))
                        .padding(18.dp)

                )
            }

            Box(
//                contentAlignment = Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dog),/*rememberImagePainter(
                        data = "https://www.vhv.rs/dpng/d/419-4194649_german-shepherd-puppy-transparent-german-shepherd-puppy-hd.png"
                        ),*/
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier
                        .size(92.dp)
                        .align(Center),
                    tint = Color.White
                )
            }

            Box(
                contentAlignment = Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text (
                    text = "Bye Bye World",
                    modifier = Modifier
                        .border(2.dp, Color.Cyan)
                        .background(MaterialTheme.colors.secondary)
                        .padding(12.dp)
                )
            }
        }
    }
} */

/*painterResource(id = R.drawable.dog),*/