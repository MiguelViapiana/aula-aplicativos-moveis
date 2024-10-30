package br.escdodev.exroom.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.escdodev.exroom.data.AfazerDatabase

@Composable
fun AfazeresNavHost(
    viewModel: AfazerViewModel
){
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "listarAfazeres"
    ) {
        composable("listarAfazeres") {
            ListarAfazeresScreen(viewModel, navController)
        }
        composable("incluirAfazeres") {
            IncluirEditarAfazerScreen(viewModel, navController )
        }
        composable("editarAfazer/{afazerId}") { navRequest ->
            val afazerId = navRequest.arguments?.getString("afazerId")
            IncluirEditarAfazerScreen(viewModel, navController,afazerId?.toInt())
        }
    }
}