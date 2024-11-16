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
import androidx.navigation.NavController
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

    var sorteio by remember { mutableStateOf(2) }
    val img_dire = when (sorteio) {
        1 -> R.drawable.deadpool___wolverine // Imagem do lado direito
        2 -> R.drawable.hellboy // Altere conforme necessário
        3 -> R.drawable.o_urso
        else -> R.drawable.got // Defina uma imagem padrão
    }

    val img_esq = when (sorteio) {
        1 -> R.drawable.hellboy // Imagem do lado esquerdo
        2 -> R.drawable.o_urso // Altere conforme necessário
        3 -> R.drawable.alien
        else -> R.drawable.you // Defina uma imagem padrão
    }

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
                painter = painterResource(id = R.drawable.fundo_oque_assistir),
                contentScale = ContentScale.Crop
            )
    ) {
        Spacer(modifier = Modifier.padding(top = 60.dp))

        Row(
            modifier = Modifier
                .clipToBounds()
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = img_esq),
                contentDescription = "Filme",
                modifier = Modifier
                    .size(40.dp)
                    .offset(y = 10.dp)
                    .offset(x = 5.dp) // Move a imagem parcialmente para fora da tela
            )
            Image(
                painter = painterResource(id = img_dire),
                contentDescription = "Filme",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = 15.dp)
                    .offset(x = (-30).dp)// Move a imagem parcialmente para fora da tela
            )
            Image(
                painter = painterResource(id = img_sorteada),
                contentDescription = "Filme",
                modifier = Modifier
                    .size(450.dp)
                    .offset(x = (-70).dp) // Move a imagem parcialmente para fora da tela
            )


        }

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
        composable("jantar") { Jantar(navController) }
        composable("pergunta") { Perguntas((navController)) }
    }
}

@Composable
fun Jantar(navController: NavController) {

    var sorteio by remember { mutableStateOf(6) }

    var roleta = when (sorteio) {
        1 -> R.drawable.roleta
        2 -> R.drawable.roleta_90
        3 -> R.drawable.roleta_90
        4 -> R.drawable.roleta_180
        5 -> R.drawable.roleta_180
        6 -> R.drawable.roleta_270
        7 -> R.drawable.roleta_270
        else -> R.drawable.roleta
    }

    val nomeJanta = when (sorteio) {
        1 -> "Noite da Sopa"
        2 -> "Noite da Lasanha"
        3 -> "Noite da Lasanha"
        4 -> "Pedir Fast-Food"
        5 -> "Pedir Fast-Food"
        6 -> "Comida Mexicana"
        7 -> "Comida Mexicana"
        else -> "Noite da Sopa"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fundo_jantar),
                contentScale = ContentScale.Crop

            )
    ) {
        Image(
            painter = painterResource(id = roleta),
            contentDescription = "Filme",
            modifier = Modifier
                .size(350.dp)
                .offset(y = 50.dp)
                .offset(x = 0.dp) // Move a imagem parcialmente para fora da tela
        )

        Image(
            painter = painterResource(id = R.drawable.arrow_red),
            contentDescription = "Filme",
            modifier = Modifier
                .size(30.dp)
                .offset(y = 25.dp)
                .offset(x = 0.dp) // Move a imagem parcialmente para fora da tela
        )

        Spacer(modifier = Modifier.padding(top = 60.dp))

        Text(
            text = nomeJanta,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFFFF000000)
        )

        Spacer(modifier = Modifier.padding(top = 190.dp))

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
fun Perguntas(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF4E4E54))
    ) {
        Text(
            text = "Para qual ocasião são \n  \n   essas perguntas?",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFFFC9CAEF),
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = { navController.navigate("") },
            modifier = Modifier
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF4139AD),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Primeiro Encontro",
                fontSize = 24.sp
            )
        }
        Button(
            onClick = { navController.navigate("") },
            modifier = Modifier
                .padding(20.dp)
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF4139AD),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Encontros Familiares",
                fontSize = 24.sp
            )
        }
        Button(
            onClick = { navController.navigate("") },
            modifier = Modifier
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF4139AD),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Time do Amigo perdeu",
                fontSize = 24.sp
            )
        }

    }
}

@Composable
fun Encontro(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC9CAEF))
    ) {
        Text(
            "Time do Amigo \n\n      Perdeu", fontSize = 32.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = 380.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.roleta777),
            contentDescription = "Filme",
            modifier = Modifier
                .size(500.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = (-50).dp)
        )

        Text(
            "Perguntas", fontSize = 32.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-383).dp)
                .padding(end = 130.dp)
        )
        Button(
            onClick = { var sorteio = (1..10).random() },
            modifier = Modifier
                .offset(y = (-130).dp)
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
fun Familia(navController: NavController) {

    var sorteio by remember { mutableStateOf(1) }

    val segundoTexto = when (sorteio % 10 + 1) {
        1 -> "Quem é mais atrapalhado?"
        2 -> "Quem é o 'chef' da casa?"
        3 -> "Qual comida é proibida?"
        4 -> "Quem conta piada ruim?"
        5 -> "Quem tem o pior gosto musical?"
        6 -> "Quem sempre perde?"
        7 -> "Quem é o mais preguiçoso?"
        8 -> "Quem é o mais bagunceiro?"
        9 -> "Quem tem mais histórias?"
        else -> "Quem ronca mais?"
    }

    val terceiroTexto = when ((sorteio + 2) % 10 + 1) { // Garante que seja um número entre 1 e 10
        1 -> "Quem é mais atrapalhado?"
        2 -> "Quem é o 'chef' da casa?"
        3 -> "Qual comida é proibida?"
        4 -> "Quem conta piada ruim?"
        5 -> "Quem tem o pior gosto musical?"
        6 -> "Quem sempre perde?"
        7 -> "Quem é o mais preguiçoso?"
        8 -> "Quem é o mais bagunceiro?"
        9 -> "Quem tem mais histórias?"
        else -> "Quem ronca mais?"
    }

    val primeiro = when (sorteio) {
        1 -> "Quem é mais atrapalhado?"
        2 -> "Quem é o 'chef' da casa?"
        3 -> "Qual comida é proibida?"
        4 -> "Quem conta piada ruim?"
        5 -> "Quem tem o pior gosto musical?"
        6 -> "Quem sempre perde?"
        7 -> "Quem é o mais preguiçoso?"
        8 -> "Quem é o mais bagunceiro?"
        9 -> "Quem tem mais histórias?"
        else -> "Quem ronca mais?"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC9CAEF))
    ) {
        Text(
            "Encontros Familiares", fontSize = 32.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = 340.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.roleta777),
            contentDescription = "Filme",
            modifier = Modifier
                .size(500.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = (-50).dp)
        )

        Text(
            "Perguntas", fontSize = 32.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-383).dp)
                .padding(end = 130.dp)
        )

        Text(
            text = primeiro,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-332).dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF000000)
        )

        Text(
            text = segundoTexto,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-315).dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF5B5B67)
        )

        Text(
            text = terceiroTexto,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-418).dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF5B5B67)
        )
        Button(
            onClick = { var sorteio = (1..10).random() },
            modifier = Modifier
                .offset(y = (-120).dp)
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
fun Amigo(navController: NavController) {
    // Lembrar o estado do sorteio e inicializar com um valor padrão
    var sorteio by remember { mutableStateOf(1) }

    // Calcular os valores de segundo e terceiro com base no sorteio
    val segundoTexto = when (sorteio % 10 + 1) { // Garante que seja um número entre 1 e 10
        1 -> "Qual é o seu sonho?"
        2 -> "Qual música você ama?"
        3 -> "Prefere praia ou montanha?"
        4 -> "Tem um filme favorito?"
        5 -> "O que te faz sorrir?"
        6 -> "Já tentou algum hobby novo?"
        7 -> "Qual viagem mais marcou?"
        8 -> "Gosta mais de café ou chá?"
        9 -> "Tem algum talento escondido?"
        else -> "Qual é a sua comida favorita?"
    }

    val terceiroTexto = when ((sorteio + 2) % 10 + 1) { // Garante que seja um número entre 1 e 10
        1 -> "Qual é o seu sonho?"
        2 -> "Qual música você ama?"
        3 -> "Prefere praia ou montanha?"
        4 -> "Tem um filme favorito?"
        5 -> "O que te faz sorrir?"
        6 -> "Já tentou algum hobby novo?"
        7 -> "Qual viagem mais marcou?"
        8 -> "Gosta mais de café ou chá?"
        9 -> "Tem algum talento escondido?"
        else -> "Qual é a sua comida favorita?"
    }

    val primeiroTexto = when (sorteio) {
        1 -> "Qual é o seu sonho?"
        2 -> "Qual música você ama?"
        3 -> "Prefere praia ou montanha?"
        4 -> "Tem um filme favorito?"
        5 -> "O que te faz sorrir?"
        6 -> "Já tentou algum hobby novo?"
        7 -> "Qual viagem mais marcou?"
        8 -> "Gosta mais de café ou chá?"
        9 -> "Tem algum talento escondido?"
        else -> "Qual é a sua comida favorita?"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC9CAEF)) // Suaviza a cor para um tom mais claro
    ) {
        Text(
            "Primeiro Encontro", fontSize = 32.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.offset(y = 340.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.roleta777),
            contentDescription = "Filme",
            modifier = Modifier
                .size(500.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = (-50).dp)
        )

        Text(
            "Perguntas", fontSize = 32.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-383).dp)
                .padding(end = 130.dp)
        )

        Text(
            text = primeiroTexto,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-332).dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF000000)
        )

        Text(
            text = segundoTexto,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-315).dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF5B5B67)
        )

        Text(
            text = terceiroTexto,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .offset(y = (-418).dp)
                .padding(end = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color(0xFF5B5B67)
        )

        Button(
            onClick = { sorteio = (1..10).random() }, // Atualiza o sorteio ao clicar
            modifier = Modifier
                .offset(y = (-190).dp)
                .width(323.dp)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4139AD),
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

        Spacer(modifier = Modifier.padding(top = 350.dp))

        Card(
            modifier = Modifier
                .width(355.dp)
                .height(219.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Precisa de ajuda para escolher ?",
                    fontSize = 21.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    fontFamily = MaterialTheme.typography.titleLarge.fontFamily
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                Button(
                    onClick = { navController.navigate("pergunta") },
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
                    onClick = { navController.navigate("jantar") },
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

    }
}

/**@Preview(showBackground = true)
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

@Preview
@Composable
private fun JantarPreview() {
EscolhaTheme {
Jantar(rememberNavController())
}

}

@Preview
@Composable
private fun PerguntasPreview() {
EscolhaTheme {
Perguntas(rememberNavController())
}

}*/

@Preview
@Composable
private fun EncontroPreview() {
    EscolhaTheme {
        Amigo(rememberNavController())
    }

}

@Preview
@Composable
private fun EncontrosPreview() {
    EscolhaTheme {
        Familia(rememberNavController())
    }

}

@Preview
@Composable
private fun EncontrossPreview() {
    EscolhaTheme {
        Encontro(rememberNavController())
    }

}
