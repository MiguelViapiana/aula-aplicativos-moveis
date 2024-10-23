package br.escdodev.planner.ui.screens.tarefas.afazares

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.escdodev.planner.R
import br.escdodev.planner.data.Afazer
import br.escdodev.planner.ui.util.PlannerTopAppBar

// Telas e Rotas
object Afazeres {
  val LISTAR_AFAZERES_ROUTE = "listar_afazeres"
  val VISUALIZAR_AFAZER_ROUTE = "visualizar_afazer/afazerId"
  val EDITAR_AFAZER_ROUTE = "editar_afazer"
  val CRIAR_AFAZER_ROUTE = "criar_afazer"
}

@Composable
fun AfazeresNavHost(
  openDrawer: () -> Unit,
  tarefasNavBar: @Composable () -> Unit,
  viewModel: AfazeresViewModel = hiltViewModel()
) {
  val navController = rememberNavController()
  val afazeres = viewModel.afazeres.collectAsStateWithLifecycle()

  NavHost(navController, startDestination = Afazeres.LISTAR_AFAZERES_ROUTE) {
    composable(Afazeres.LISTAR_AFAZERES_ROUTE) {
      AfazeresScreen(
        afazeres.value,
        {
          PlannerTopAppBar(
            Icons.Default.Menu,
            stringResource(id = R.string.afazeres),
            openDrawer
          )
        },
        tarefasNavBar,
        navController
      )
    }
    composable("${Afazeres.VISUALIZAR_AFAZER_ROUTE}/{afazerId}") { backStackEntry ->
      val afazerId = backStackEntry.arguments?.getString("afazerId")?.toInt()
      val afazer = afazeres.value.find { it.id == afazerId }!! //Força não nulo
      VisualizarAfazerScreen(
        afazer,
        {
          PlannerTopAppBar(
            Icons.AutoMirrored.Filled.ArrowBack,
            stringResource(id = R.string.detalhes_afazer)
          ) {
            navController.popBackStack()
          }
        },
        navController = navController
      )
    }
    composable(Afazeres.CRIAR_AFAZER_ROUTE) {
      CriarEditarAfazerScreen(
        Afazer(),
        voltarAoSalvar = {
          navController.popBackStack()
        },
        afazeresTopBar = {
          PlannerTopAppBar(
            Icons.AutoMirrored.Filled.ArrowBack,
            stringResource(id = R.string.novo_afazer)
          ) {
            navController.popBackStack()
          }
        }
      )
    }
    composable("${Afazeres.EDITAR_AFAZER_ROUTE}/{afazerId}") { backStackEntry ->
      val afazerId = backStackEntry.arguments?.getString("afazerId")?.toInt()
      val afazer = afazeres.value.firstOrNull { it.id == afazerId }!!
      CriarEditarAfazerScreen(
        afazer,
        voltarAoSalvar = {
          navController.popBackStack()
        },
        afazeresTopBar = {
          PlannerTopAppBar(
            Icons.AutoMirrored.Filled.ArrowBack,
            stringResource(id = R.string.editar_afazer)
          ) {
            navController.popBackStack()
          }
        }
      )
    }
  }
}