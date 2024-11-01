package br.escdodev.exroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.escdodev.exroom.data.AfazerDatabase.Companion.abrirBancoDeDados
import br.escdodev.exroom.data.LocalRepository
import br.escdodev.exroom.data.RemoteRepository
import br.escdodev.exroom.ui.AfazerViewModel
import br.escdodev.exroom.ui.AfazeresNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val is_local = false

        val db = abrirBancoDeDados(this)
        //val viewModel = AfazerViewModel(db.afazerDao())
        val localRepository = LocalRepository(db.afazerDao())
        val remoteRepository = RemoteRepository()
        val viewModel : AfazerViewModel

        if(is_local){
            viewModel = AfazerViewModel(localRepository)
        }else{
            viewModel = AfazerViewModel(remoteRepository)
        }

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