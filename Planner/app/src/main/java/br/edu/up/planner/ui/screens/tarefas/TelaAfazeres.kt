package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBotomBar

@Composable
fun TelaUmA(drawerState: DrawerState, navCtrlBottomNav: NavController) {

    var afazeres = mutableListOf(
        Afazer(
            titulo = "Comprar carro",
            descricao = "Visitar concessionaria",
            id = 1
        ),
        Afazer(
            titulo = "Lavar roupa",
            descricao = "Lavar roupa pela manhã",
            id = 2
        )
    )

    Scaffold(
        topBar = { PlannerTopBar(drawerState = drawerState) },
        content = { padding ->
            padding

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(afazeres) { afazer ->
                    Row {
                        Column {
                            Text(
                                text = afazer.titulo,
                                textAlign = TextAlign.Center,
                                fontSize = 30.sp
                            )
                            Text(
                                text = afazer.descricao,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        },
        bottomBar = { TelaUmBotomBar(navController = navCtrlBottomNav) },
        floatingActionButton = { FloatButtom() }
    )
}

@Composable
private fun FloatButtom() {
    FloatingActionButton(onClick = { }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "+"
        )
    }
}



data class Afazer(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    var id: Int? = null
)