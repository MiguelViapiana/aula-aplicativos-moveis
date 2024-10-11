package br.escdodev.planner.ui.screens.tarefas.afazares

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import br.escdodev.planner.data.Afazer
import br.escdodev.planner.ui.theme.corVerdeDevMais
import br.escdodev.planner.ui.theme.corVerdeLeve
import br.escdodev.planner.ui.theme.corVermelhoDevMais
import kotlinx.coroutines.launch

@Composable
fun AfazeresScreen(
  afazeres: List<Afazer>,
  afazeresTopBar: @Composable () -> Unit,
  tarefasNavBar: @Composable () -> Unit,
  navController: NavController,
  viewModel: AfazeresViewModel = hiltViewModel()
) {

  val currentBack by navController.currentBackStackEntryAsState()
  val rotaAtual = currentBack?.destination?.route ?: Afazeres.LISTAR_AFAZERES_ROUTE

  Scaffold(
    topBar = { afazeresTopBar() },
    content = { innerPadding -> innerPadding
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 20.dp)
      ) {
        Spacer(modifier = Modifier.height(130.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
          items(afazeres) { afazer ->
            ItemAfazer(
              afazer = afazer,
              onAfazerCheck = {
                selecionado -> viewModel.atualizarAfazer(afazer,selecionado)
              },
              onAfazerClick = {
                navController.navigate("${Afazeres.VISUALIZAR_AFAZER_ROUTE}/${afazer.id}")
              },
              onDelete = {
                viewModel.excluir(afazer)
              }
            )
          }
        }
        Spacer(modifier = Modifier.height(130.dp))
      }
    },
    floatingActionButton = {
      FloatingActionButton(
        shape = CircleShape,
        containerColor = corVerdeLeve,
        contentColor = Color.White,
        onClick = { navController.navigate(Afazeres.CRIAR_AFAZER_ROUTE) }
      ) {
        Icon(Icons.Filled.Add, "+")
      }
    },
    bottomBar = {
      if (rotaAtual == Afazeres.LISTAR_AFAZERES_ROUTE) {
        tarefasNavBar()
      }
    }
  )
}

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun ItemAfazer(
  afazer: Afazer,
  onAfazerCheck: (Boolean) -> Unit,
  onAfazerClick: (Afazer) -> Unit,
  onDelete: () -> Unit
) {

  val scope = rememberCoroutineScope()
  val deslocPx = with(LocalDensity.current) { (-50).dp.toPx() }
  val swipeState = rememberSwipeableState(0)

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onAfazerClick(afazer) }
      .swipeable(
        state = swipeState,
        anchors = mapOf(0f to 0, -1000f to 1),
        orientation = Orientation.Horizontal
      )
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      if (swipeState.offset.value > deslocPx) {
        Checkbox(
          checked = afazer.concluido,
          onCheckedChange = { onAfazerCheck(it) },
          colors = CheckboxDefaults.colors(
            checkedColor = corVerdeDevMais
          ),
          modifier = Modifier.height(50.dp)
        )
      } else {
        IconButton(
          onClick = {
            onDelete()
            scope.launch { swipeState.snapTo(0) }
          },
          modifier = Modifier.height(50.dp)
        ) {
          Icon(
            Icons.Filled.Delete,
            contentDescription = "Excluir",
            tint = corVermelhoDevMais,
            modifier = Modifier.size(30.dp)
          )
        }
      }
      Spacer(modifier = Modifier.width(16.dp))
      Text(
        text = afazer.titulo,
        fontSize = 20.sp
      )
    }
  }
}