package br.edu.up.planner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.PrimeiraTela
import br.edu.up.planner.ui.screens.SegundaTela

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    device = Devices.PIXEL
)
//@Preview(
//    device = Devices.NEXUS_10
//)
@Composable
fun PlannerApp(){

    var tela = remember { mutableStateOf(1) }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Planner", fontSize = 40.sp) },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFF03A9F4)))
        },

        content = { padding ->
            Text(text = "Conteúdo", Modifier.padding(padding),
                fontSize = 50.sp)
        }
    )


    }

@Composable
fun PlannerAppManual(){
    var tela = remember { mutableStateOf(1) }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Row(modifier = Modifier
                .height(70.dp)
                .background(Color(0xC403A9F4))
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically)
            {
                Text(text = "Planner",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight(800),

                    )
            }
            Row(modifier = Modifier.weight(1f)) {
                when(tela.value){
                    1 -> PrimeiraTela()
                    2-> SegundaTela()
                }
            }

            Row(modifier = Modifier
                .height(70.dp)
                .background(Color(0xC403A9F4))
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically)
            {
                Button(onClick = {
                    tela.value = 1
                }, modifier = Modifier.padding(10.dp)) {
                    Text(text = "Tela 1", fontSize = 20.sp)
                }
                Button(onClick = {
                    tela.value = 2
                }, modifier = Modifier.padding(10.dp)) {
                    Text(text = "Tela 2", fontSize = 20.sp)
                }
            }
        }


    }
}




