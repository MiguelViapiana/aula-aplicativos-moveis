package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBotomBar

@Composable
fun TelaNotas(drawerState: DrawerState, navCtrlBottomNav: NavController) {
    Scaffold(
        topBar = { PlannerTopBar(drawerState = drawerState) },
        content = { padding -> padding
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Tela Anotações", Modifier.padding(30.dp),
                    fontSize = 50.sp
                )
            }
        },
        bottomBar = { TelaUmBotomBar(navController = navCtrlBottomNav)}
    )
}