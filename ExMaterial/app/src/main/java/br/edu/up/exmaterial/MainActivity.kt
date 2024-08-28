package br.edu.up.exmaterial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.up.exmaterial.ui.screen.HomeScreen
import br.edu.up.exmaterial.ui.screen.SegundaScreen
import br.edu.up.exmaterial.ui.screen.TerceriaScreen
//import br.edu.up.exmaterial.ui.theme.ExMaterialTheme
import br.edu.up.exmaterial.ui.theme.MeuTema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuTema {
                MeuApp()
            }
        }
    }
}


