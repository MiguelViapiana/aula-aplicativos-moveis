package br.edu.up.planner

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.TarefasSceen

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    device = Devices.PIXEL
)
@Composable
fun PlannerApp(){

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)
    

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent() },
        content = { TarefasSceen(drawerState) }
    )
}

@Composable
private fun DrawerContent() {
    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color.White)
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(text = "Item 1", fontSize = 30.sp)
        Text(text = "Item 2", fontSize = 30.sp)
        Text(text = "Item 3", fontSize = 30.sp)
    }
}
//@Composable
//fun PlannerAppManual(){
//    var tela = remember { mutableStateOf(1) }
//    Surface(modifier = Modifier.fillMaxSize()) {
//        Column {
//            Row(modifier = Modifier
//                .height(70.dp)
//                .background(Color(0xC403A9F4))
//                .fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically)
//            {
//                Text(text = "Planner",
//                    fontSize = 30.sp,
//                    color = Color.White,
//                    fontWeight = FontWeight(800),
//
//                    )
//            }
//            Row(modifier = Modifier.weight(1f)) {
//                when(tela.value){
//                    1 -> PrimeiraTela()
//                    2-> SegundaTela()
//                }
//            }
//
//            Row(modifier = Modifier
//                .height(70.dp)
//                .background(Color(0xC403A9F4))
//                .fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically)
//            {
//                Button(onClick = {
//                    tela.value = 1
//                }, modifier = Modifier.padding(10.dp)) {
//                    Text(text = "Tela 1", fontSize = 20.sp)
//                }
//                Button(onClick = {
//                    tela.value = 2
//                }, modifier = Modifier.padding(10.dp)) {
//                    Text(text = "Tela 2", fontSize = 20.sp)
//                }
//            }
//        }
//
//
//    }
//}




