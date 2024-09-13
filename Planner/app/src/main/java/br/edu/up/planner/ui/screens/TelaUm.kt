package br.edu.up.planner.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.util.PlannerTopBar

@Composable
fun TelaUm(drawerState: DrawerState) {
    Scaffold(
        topBar = { PlannerTopBar(drawerState = drawerState) },
        content = { padding -> ConteudoPrincipal(padding) },
        floatingActionButton = { FloatButtom() },
        bottomBar = { BottomAppBarMinima() }

    )
}

@Composable
private fun BottomAppBarMinima() {
    BottomAppBar(
        containerColor = Color(0xD803A9F4)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "C",
                modifier = Modifier.size(40.dp)
            )
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "F",
                modifier = Modifier.size(40.dp)
            )
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = "B",
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
private fun FloatButtom() {
    FloatingActionButton(onClick = { }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "+")
    }
}

@Composable
private fun ConteudoPrincipal(padding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Tela 1", Modifier.padding(padding),
            fontSize = 50.sp
        )
    }
}
