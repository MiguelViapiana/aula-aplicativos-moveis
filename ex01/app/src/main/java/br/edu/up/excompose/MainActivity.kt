package br.edu.up.excompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.edu.up.excompose.ui.theme.ExComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Card("O primeiro componente ALTERADO NA EDIÇÂO...")
        }
    }
}

data class Mensagem(val autor: String, val texto: String)

@Composable
fun Card(msg : Mensagem){
    Row {
        Image(
        painter = painterResource(id = R.drawable.fotobacana),
        contentDescription = "Foto"
        )
        
        Column{


            Text(msg.autor)
            Text( msg.texto)
        }
    }


}

@Composable
@Preview
fun PreviewCard(){
    Card(msg = Mensagem("Migas" , "Olá Mundo"))


}
