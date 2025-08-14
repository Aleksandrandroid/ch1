package com.example.ch1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import com.example.ch1.ui.theme.fontFamily
import com.example.ch1.ui.theme.montt25
import com.example.ch1.ui.theme.roboto15


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        ScreenTop()
        ScreenBottom()
    }
}

@Composable
fun ScreenTop() {
    var likeColor by remember { mutableStateOf(Color.White) }

    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(10.dp)
    )
    {
        Column(
            modifier = Modifier
                .background(color = Color(0xFF284578))
                .fillMaxWidth()
                .height(400.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,

            ) {
            Image(
                painter = painterResource(R.drawable.istockphoto),
                contentDescription = "Scenery",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp)
            )
            Text(
                text = "Красивый пейзаж",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                style = montt25
            )

            Text(
                text = "Озеро в горах",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(15.dp),
                style = montt25
            )

            IconButton(
                onClick = { likeColor = Color(0xFFE3861E) },
                modifier = Modifier
                    // .align(Alignment.End)
                    .padding(start = 270.dp, bottom = 10.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Like",
                    tint = likeColor,
                    modifier = Modifier
                        .size(35.dp)
                )
            }
        }
    }

}


@Composable
fun ScreenBottom() {
    var bellColor by remember { mutableStateOf(Color.White) }
    var faceColor by remember { mutableStateOf(Color.White) }
    var doneColor by remember { mutableStateOf(Color.White) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF284578)),
            horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.cheburashka),
                contentDescription = "Cheburaha",
                modifier = Modifier
                    .size(180.dp),
                //   .padding(bottom = 25.dp),
                // .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.FillWidth,


            )

            Text(
                text = "Profile",
                style = montt25,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 15.dp),
                textAlign = TextAlign.End
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                IconButton(onClick = { doneColor = Color(0xFFE3861E) }) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "Ready",
                        tint = doneColor,
                        modifier = Modifier
                            .size(35.dp)
                        //   .padding(bottom = 20.dp)

                    )
                }

                IconButton(onClick = { faceColor = Color(0xFFE3861E) }) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "Face",
                        tint = faceColor,
                        modifier = Modifier
                            .size(35.dp)

                    )
                }

                IconButton(onClick = { bellColor = Color(0xFFE3861E) }) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Bell",
                        tint = bellColor,
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
            }

        }
    }


}


@Preview(showBackground = true)
@Composable
fun Preview() {
    ProfileScreen()
}
