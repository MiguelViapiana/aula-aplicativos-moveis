package br.edu.up.planner.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar

object TelaUm {
    val TELA_UM_A_ROUTE = "t1a"
    val TELA_UM_B_ROUTE = "t1b"
    val TELA_UM_C_ROUTE = "t1c"
}

@Composable
fun TelaUm(drawerState: DrawerState) {

    val navController = rememberNavController()

    Scaffold(
        topBar = { PlannerTopBar(drawerState = drawerState) },
        content = { padding ->

            NavHost(navController = navController, startDestination = TelaUm.TELA_UM_A_ROUTE)
            {
                composable(TelaUm.TELA_UM_A_ROUTE)
                {
                    TelaUmA(padding)
                }
                composable(TelaUm.TELA_UM_B_ROUTE)
                {
                    TelaUmB(padding)
                }
                composable(TelaUm.TELA_UM_C_ROUTE)
                {
                    TelaUmC(padding)
                }
            }
        },
        floatingActionButton = { FloatButtom() },
        bottomBar = { BottomAppBarMinima(navController) }

    )
}

@Composable
private fun BottomAppBarMinima(navController: NavController) {


    NavigationBar(
        containerColor = Color(0xD803A9F4)
    ) {
        NavigationBarItem(selected = false,
            onClick = {
                navController.navigate(TelaUm.TELA_UM_A_ROUTE)
            }, icon = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {Text("Tela A")}
        )

        NavigationBarItem(selected = false,
            onClick = {
                navController.navigate(TelaUm.TELA_UM_B_ROUTE)
            }, icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "B",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {Text("Tela B")}
        )

        NavigationBarItem(selected = false,
            onClick = {
                navController.navigate(TelaUm.TELA_UM_C_ROUTE)
            }, icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "C",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {Text("Tela C")}
        )
    }
}

@Composable
private fun FloatButtom() {
    FloatingActionButton(onClick = { }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "+")
    }
}


