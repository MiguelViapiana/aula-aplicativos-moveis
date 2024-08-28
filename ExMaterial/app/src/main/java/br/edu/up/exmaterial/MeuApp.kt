package br.edu.up.exmaterial

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.edu.up.exmaterial.ui.screen.HomeScreen
import br.edu.up.exmaterial.ui.screen.SegundaScreen
import br.edu.up.exmaterial.ui.screen.TerceriaScreen

@Composable
fun MeuApp(innerPadding: Modifier = Modifier){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val tela = 1
        val padding = Modifier.padding(innerPadding)
        when(tela){
            1 -> HomeScreen("Tela Principal", modifier = padding)
            2 -> SegundaScreen(titulo = "Segunda tela", modifier = padding)
            3 -> TerceriaScreen(titulo = "Terceria tela", modifier = padding )
        }
    }
}