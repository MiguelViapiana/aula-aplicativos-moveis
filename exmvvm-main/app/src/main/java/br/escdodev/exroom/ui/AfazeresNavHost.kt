package br.escdodev.exroom.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.escdodev.exroom.data.AfazerDatabase

@Composable
fun AfazeresNavHost(
    db: AfazerDatabase
){
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "listarAfazeres"
    ) {
        composable("listarAfazeres") {
            ListarAfazeresScreen(db, navController)
        }
        composable("incluirAfazeres") {
            IncluirEditarAfazerScreen(db, navController)
        }
    }
}