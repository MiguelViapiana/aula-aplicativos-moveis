package br.escdodev.planner.ui.screens.tarefas.afazares

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import br.escdodev.planner.data.Afazer
import br.escdodev.planner.ui.theme.corVerdeDevMais
import br.escdodev.planner.ui.theme.corVerdeLeve

@Composable
fun CriarEditarAfazerScreen(
  afazer: Afazer,
  voltarAoSalvar: () -> Unit,
  afazeresTopBar: @Composable () -> Unit,
  viewModel: AfazeresViewModel = hiltViewModel()
) {

  val fontSize = 20.sp
  var titulo by remember { mutableStateOf(afazer.titulo) }
  var descricao by remember { mutableStateOf(afazer.descricao) }

  Scaffold(
    topBar = { afazeresTopBar() },
    content = { innerPadding ->
      Column(
        Modifier
          .padding(innerPadding)
          .fillMaxWidth()
          .padding(16.dp)
      ) {
        Text(
          text = "Título", fontSize = 15.sp, fontWeight = FontWeight(500),
          modifier = Modifier.padding(0.dp, 8.dp)
        )
        OutlinedTextField(
          value = titulo,
          textStyle = TextStyle(
            fontSize = fontSize,
            fontWeight = FontWeight.Normal
          ),
          onValueChange = { titulo = it },
          modifier = Modifier.fillMaxWidth(),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = corVerdeDevMais,
            focusedContainerColor = Color(0xFFFCF9E7)
          )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
          text = "Descrição", fontSize = 15.sp, fontWeight = FontWeight(500),
          modifier = Modifier.padding(0.dp, 8.dp)
        )
        OutlinedTextField(
          value = descricao,
          textStyle = TextStyle(
            fontSize = fontSize,
            fontWeight = FontWeight.Normal
          ),
          onValueChange = { descricao = it },
          modifier = Modifier.fillMaxWidth(),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = corVerdeDevMais,
            focusedContainerColor = Color(0xFFFCF9E7)
          )
        )
        Spacer(modifier = Modifier.height(20.dp))
      }
    },
    floatingActionButton = {
      FloatingActionButton(
        shape = CircleShape,
        containerColor = corVerdeLeve,
        contentColor = Color.White,
        onClick = {
          viewModel.salvar(
            Afazer(
              titulo = titulo,
              descricao = descricao,
              concluido = afazer.concluido,
              id = afazer.id
            ))
          voltarAoSalvar()
        }
      ) {
        Icon(Icons.Filled.Check, "Salvar")
      }
    }
  )
}