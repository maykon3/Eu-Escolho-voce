package com.example.escolha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.escolha.ui.theme.EscolhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EscolhaTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Inicio()
                }
            }
        }
    }
}

@Composable
fun Sorteio(navController: androidx.navigation.NavController) {
    var sorteio by remember { mutableStateOf(1) }
    val img_sorteada = when (sorteio) {
        1 -> R.drawable.featuredimage
        2 -> R.drawable.filme4_xml
        3 -> R.drawable.filme3_xml
        4 -> R.drawable.download__1_
        5 -> R.drawable.filme5
        else -> R.drawable.images__5_
    }
    val nomeDoFilme = when (sorteio) {
        1 -> "Terror"
        2 -> "Comedia"
        3 -> "Ação"
        4 -> "Romance"
        5 -> "Suspense"
        else -> "Romance"
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 20.dp)
            .background(color = Color.Black)
    ) {

        Text(
            text = "Qual o Filme para hoje ?",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily
        )

        Card(
            modifier = Modifier
                .padding(20.dp)
                .height(50.dp)
                .width(200.dp)
        ) {
            Text(
                text = nomeDoFilme,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Black,
            )
        }

        Image(
            painter = painterResource(id = img_sorteada),
            contentDescription = "Filme",
            modifier = Modifier
                .padding(top = 16.dp)
                .width(400.dp)
                .height(400.dp)
                .align(Alignment.CenterHorizontally)
        )

        Button(
            onClick = { sorteio = (1..6).random() },
            modifier = Modifier
                .padding(20.dp)
                .width(220.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Unspecified,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Escolher",
                fontSize = 29.sp
            )
        }
    }
}

@Composable
fun Inicio() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") { InicioScreen(navController) }
        composable("home") { Sorteio(navController) }
    }
}

@Composable
fun InicioScreen(navController: androidx.navigation.NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp)
    ) {
        Text(
            text = "Eu escolho por Você!",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily
        )

        Card(
            modifier = Modifier
                .padding(20.dp)
                .height(46.dp)
                .width(250.dp)
        ) {
            Text(
                text = "O que vou assistir?",
                fontSize = 27.sp,
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Black,
            )
        }

        Image(
            painter = painterResource(id = R.drawable.duvida),
            contentDescription = "Filme",
            modifier = Modifier
                .padding(top = 5.dp)
                .width(350.dp)
                .height(400.dp)
                .align(Alignment.CenterHorizontally)
        )

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .padding(20.dp)
                .width(220.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Unspecified,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Escolher",
                fontSize = 29.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EscolhaTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Inicio()
        }
    }
}
