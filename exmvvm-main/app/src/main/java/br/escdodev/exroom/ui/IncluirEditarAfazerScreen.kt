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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.escdodev.exroom.data.Afazer
import br.escdodev.exroom.data.AfazerDatabase
import kotlinx.coroutines.launch

@Composable
fun IncluirEditarAfazerScreen(
    viewModel: AfazerViewModel,
    navController: NavController,
    afazerId: Int? = null
){
    var coroutineScope = rememberCoroutineScope()

    // Dados do novo afazer
    var titulo by remember {  mutableStateOf( "") }
    var descricao by remember { mutableStateOf( "") }

    var afazer: Afazer? by remember { mutableStateOf(null) }

    val label = "Novo afazer"

    LaunchedEffect(afazerId) {
        coroutineScope.launch {
            if(afazerId != null){
                afazer = viewModel.buscarAfazerPorId(afazerId)
                afazer?.let{
                    titulo = it.titulo
                    descricao = it.descricao
                }
            }
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
        Text(
            text = "Novo Afazer",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            //Serve para disparar o segundo processo
            coroutineScope.launch {
                val afazerSalvar = Afazer(
                    id = afazerId,
                    titulo = titulo,
                    descricao = descricao
                )
                viewModel.gravar(afazerSalvar)
                navController.navigate("listarAfazeres")
            }
        }) {
            Text(text = "Salvar", fontSize = 30.sp)
        }
    }
}