package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object TelaUm {
    val TELA_AFAZERES_ROUTE = "telaAfazeres"
    val TELA_ROTINA_ROUTE = "telaRotina"
    val TELA_NOTAS_ROUTE = "telaNotas"

}

@Composable
fun TarefasNavHost(drawerState: DrawerState) {

    val navCtrlBottomNav = rememberNavController()

    NavHost(navController = navCtrlBottomNav, startDestination = TelaUm.TELA_AFAZERES_ROUTE)
    {
        composable(TelaUm.TELA_AFAZERES_ROUTE)
        {
            TelaUmA(drawerState, navCtrlBottomNav)
        }
        composable(TelaUm.TELA_ROTINA_ROUTE)
        {
            TelaUmB(drawerState, navCtrlBottomNav)
        }
        composable(TelaUm.TELA_NOTAS_ROUTE)
        {
            TelaUmC(drawerState, navCtrlBottomNav)
        }
    }
}






