package br.escdodev.exroom.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.escdodev.exroom.data.Afazer
import br.escdodev.exroom.data.AfazerDatabase
import br.escdodev.exroom.data.AfazerDatabase.Companion.abrirBancoDeDados
import kotlinx.coroutines.launch

@Composable
fun ListarAfazeresScreen(
    db: AfazerDatabase,
    navController: NavController
){
    var coroutineScope = rememberCoroutineScope()

    // Popular e carregar dados do banco
    var afazeres by remember { mutableStateOf(listOf<Afazer>()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            if(db.afazerDao().listarAfazeres().isEmpty()){
                db.afazerDao().gravarAfazer(
                    Afazer(titulo="Afazer A", descricao = "A")
                )
                db.afazerDao().gravarAfazer(
                    Afazer(titulo="Afazer B", descricao = "B")
                )
                db.afazerDao().gravarAfazer(
                    Afazer(titulo="Afazer C", descricao = "C")
                )
            }
            afazeres = db.afazerDao().listarAfazeres()
        }
    }
    Column(
        modifier = Modifier.padding(
            top =  90.dp,
            start = 30.dp,
            end = 30.dp,
            bottom = 30.dp
        )
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Lista de afazeres",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(10.dp))
        for(afazer in afazeres){
            Text(text = afazer.titulo,
                fontSize = 30.sp)
        }

        Button(onClick = {
            navController.navigate("incluirAfazeres")
        }) {
            Text(text = "Novo Afazer")
        }
    }
}