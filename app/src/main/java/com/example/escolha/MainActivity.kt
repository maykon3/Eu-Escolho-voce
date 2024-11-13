package com.example.escolha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                Inicio()
            }
        }
    }
}

val corEscura = Color(0xFFFF17162D)
val roxo = Color(0xFFFF4139AD)

@Composable
fun Sorteio(navController: androidx.navigation.NavController) {

    var sorteio by remember { mutableStateOf(1) }
    var sorteio_d = sorteio + 1
    var sorteio_e = sorteio_d + 1

    val img_sorteada = when (sorteio) {
        1 -> R.drawable.credd
        2 -> R.drawable.deadpool___wolverine
        3 -> R.drawable.hellboy
        4 -> R.drawable.o_urso
        5 -> R.drawable.alien
        6 -> R.drawable.the_last_of_us
        7 -> R.drawable.stranger_things
        8 -> R.drawable.got
        9 -> R.drawable.you
        else -> R.drawable.sem_dor__sem_ganho
    }
    val img_direita = when (sorteio_d) {
        1 -> R.drawable.credd
        2 -> R.drawable.deadpool___wolverine
        3 -> R.drawable.hellboy
        4 -> R.drawable.o_urso
        5 -> R.drawable.alien
        6 -> R.drawable.the_last_of_us
        7 -> R.drawable.stranger_things
        8 -> R.drawable.got
        9 -> R.drawable.you
        else -> R.drawable.sem_dor__sem_ganho
    }
    val img_esquerda = when (sorteio_e) {
        1 -> R.drawable.credd
        2 -> R.drawable.deadpool___wolverine
        3 -> R.drawable.hellboy
        4 -> R.drawable.o_urso
        5 -> R.drawable.alien
        6 -> R.drawable.the_last_of_us
        7 -> R.drawable.stranger_things
        8 -> R.drawable.got
        9 -> R.drawable.you
        else -> R.drawable.sem_dor__sem_ganho
    }
    val nomeDoFilme = when (sorteio) {
        1 -> "Filme: Credd "
        2 -> "Filme: Deadpool e Wolverine "
        3 -> "Filme: Hellboy "
        4 -> "Série: O Urso "
        5 -> "Filme: Alien "
        6 -> "Serie: The Last ot US "
        7 -> "Serie: Stranger Things "
        8 -> "Serie: Game Of Thrones "
        9 -> "Serie: YOU "
        else -> "Filme: Sem dor, Sem Ganho "
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.backgtound_escolha),
                contentScale = ContentScale.Crop
            )
    ) {
        Spacer(modifier = Modifier.padding(top = 60.dp))

        Row(
            modifier = Modifier
                .clipToBounds()
        ) {
            Image(
                painter = painterResource(id = img_esquerda),
                contentDescription = "Filme",
                modifier = Modifier
                    .size(50.dp)
                    .offset(x = (30).dp)
            )
            Image(
                painter = painterResource(id = img_direita),
                contentDescription = "Filme",
                modifier = Modifier
                    .size(100.dp)
                    .offset(x = (-10).dp) // Move a imagem parcialmente para fora da tela
            )
            Image(
                painter = painterResource(id = img_sorteada),
                contentDescription = "Filme",
                modifier = Modifier
                    .width(500.dp)
                    .height(400.dp)
                    .offset(x = (-80).dp)
            )

        }

        Spacer(modifier = Modifier.padding(top = 10.dp))


        Text(
            text = nomeDoFilme,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFFFF000000)
        )

        Button(
            onClick = { sorteio = (1..10).random() },
            modifier = Modifier
                .padding(20.dp)
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF4139AD),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Escolher",
                fontSize = 24.sp
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.tela_de_inicio),
                contentScale = ContentScale.Crop
            )
    ) {
        Text(
            text = "Eu Escolho Você",
            fontSize = 30.sp,
            color = Color.Transparent,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(top = 144.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily
        )

        Spacer(modifier = Modifier.padding(top = 390.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = corEscura,
                contentColor = Color.White
            ),
        ) {
            Text(
                text = "Perguntas Aleatorias",
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }

        Spacer(modifier = Modifier.padding(top = 8.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = roxo,
                contentColor = Color.White
            ),

            ) {
            Text(
                text = "O que assistir",
                fontSize = 18.sp, fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.padding(top = 8.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = corEscura,
                contentColor = Color.White
            ),

            ) {
            Text(
                text = "Jantar em Familia ",
                fontSize = 18.sp, fontWeight = FontWeight.Medium
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EscolhaTheme {
        InicioScreen(rememberNavController())
    }
}

@Preview
@Composable
private fun SorteioPreview() {
    EscolhaTheme {
        Sorteio(rememberNavController())
    }

}
