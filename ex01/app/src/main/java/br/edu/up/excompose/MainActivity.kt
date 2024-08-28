package br.edu.up.excompose

import android.content.res.Configuration
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun Card(msg : Mensagem) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.fotobacana),
            contentDescription = "Foto",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = msg.autor,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.width(8.dp))
            Surface (shape = MaterialTheme.shapes.large,
                    shadowElevation = 1.dp){
                Text(text = msg.texto,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodyMedium)
            }



        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Modo Dark"
)

@Composable
@Preview
fun PreviewCard(){
    Card(msg = Mensagem("Migas" , "Olá Mundo"))


}
