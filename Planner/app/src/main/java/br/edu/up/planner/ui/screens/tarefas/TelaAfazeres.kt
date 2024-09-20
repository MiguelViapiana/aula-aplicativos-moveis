package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBotomBar

object TarefasRota{
    val TELA_LISTAR_AFAZERES_ROTA = "listar_afazeres"
    val TELA_INCLUIR_AFAZERE_ROTA = "incluir_afazer"
}


@Composable
fun TelAfazeres(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {



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

    val navCtrlTarefas = rememberNavController()

    Scaffold(
        topBar = { PlannerTopBar(drawerState = drawerState) },
        content = { padding ->
            padding

            NavHost(navController = navCtrlTarefas, startDestination = TarefasRota.TELA_LISTAR_AFAZERES_ROTA ){
                composable(TarefasRota.TELA_INCLUIR_AFAZERE_ROTA) {
                    TelaListagemAfazeres(afazeres)
                }
                composable(TarefasRota.TELA_INCLUIR_AFAZERE_ROTA) {
                    Text(text = "TELA DE INCLUIR AFAZER")
                }
            }

        },
        bottomBar = { TelaUmBotomBar(navController = navCtrlBottomNav) },
        floatingActionButton = { FloatButtom() }
    )
}

@Composable
private fun TelaListagemAfazeres(afazeres: MutableList<Afazer>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(afazeres) { afazer ->
            Column {
                Text(
                    text = afazer.titulo,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
            }
        }
    }
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