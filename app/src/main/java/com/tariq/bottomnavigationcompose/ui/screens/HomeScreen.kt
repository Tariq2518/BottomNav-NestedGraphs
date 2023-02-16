package com.tariq.bottomnavigationcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Home Screen",
                color = Color.Black,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(24.dp, 0.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                modifier = Modifier
                    .height(46.dp)
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp)
                    .clickable {

                    },
                text = "Home screen is here",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h6.fontSize
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}

