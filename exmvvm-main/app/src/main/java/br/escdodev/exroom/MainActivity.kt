package br.escdodev.exroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.escdodev.exroom.data.AfazerDatabase
import br.escdodev.exroom.data.AfazerDatabase.Companion.abrirBancoDeDados
import br.escdodev.exroom.ui.AfazerViewModel
import br.escdodev.exroom.ui.AfazeresNavHost
import br.escdodev.exroom.ui.IncluirEditarAfazerScreen
import br.escdodev.exroom.ui.ListarAfazeresScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = abrirBancoDeDados(this)
        val viewModel = AfazerViewModel(db.afazerDao())
        setContent {
            AfazeresNavHost(viewModel)
        }
    }
}

//@Composable
//fun IncluirAfazerScreen(
//    db: AfazerDatabase,
//    navController: NavController
//){
//    Text(text = "Tela para incluir afazer")
//}