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
    var bellColor by remember { mutableStateOf(Color.DarkGray) }
    var faceColor by remember { mutableStateOf(Color.DarkGray) }
    var doneColor by remember { mutableStateOf(Color.DarkGray) }
    var likeColor by remember { mutableStateOf(Color.DarkGray) }

    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(10.dp),

        )

    {
        Column(
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxWidth()
                .height(400.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Image(
                painter = painterResource(R.drawable.istockphoto),
                contentDescription = "Scenery",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Красивый пейзаж",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Озеро в горах",
                fontSize = 16.sp
            )

            IconButton(
                onClick = { likeColor = Color(0xFF7D5260) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Like",
                    tint = likeColor,
                    modifier = Modifier
                        .size(40.dp),
                )
            }


        }
    }


    //нижняя колонка с чебурашкой

    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(R.drawable.cheburashka),
            contentDescription = "QWERTY",
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.FillWidth

        )

        Text(
            text = "Profile",
            style = montt25,
            color = Color(0xFF6200EE),
            modifier = Modifier,
            textAlign = TextAlign.End
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            IconButton(onClick = { doneColor = Color(0xFFbd4a59) }) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Ready",
                    tint = doneColor,
                    modifier = Modifier
                        .size(50.dp)

                )
            }

            IconButton(onClick = { faceColor = Color(0xFFFF4081) }) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Face",
                    tint = faceColor,
                    modifier = Modifier
                        .size(50.dp)

                )
            }

            IconButton(onClick = { bellColor = Color(0xFFFF4081) }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Bell",
                    tint = bellColor,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    ProfileScreen()
}
