package br.edu.up.planner



import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.planner.ui.screens.TelaDois
import br.edu.up.planner.ui.screens.TelaTres
import br.edu.up.planner.ui.screens.TelaUm
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

object PlannerRotas{
    val TELA_UM_ROTA = "tela_um"
    val TELA_DOIS_ROTA = "tela_dois"
    val TELA_TRES_ROTA = "tela_tres"
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    device = Devices.PIXEL
)
@Composable
fun PlannerApp() {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController, drawerState)
                        },
        content = {

            NavHost(
                navController = navController,
                startDestination = PlannerRotas.TELA_UM_ROTA)
            {
                composable(PlannerRotas.TELA_UM_ROTA) {
                    TelaUm(drawerState)
                }
                composable(PlannerRotas.TELA_DOIS_ROTA) {
                    TelaDois(drawerState)
                }
                composable(PlannerRotas.TELA_TRES_ROTA) {
                    TelaTres(drawerState)
                }
            }
        }
    )
}

@Composable
private fun DrawerContent(navController: NavController, drawerState: DrawerState) {
    
    val coroutineScope = rememberCoroutineScope()

    val currentBack by navController.currentBackStackEntryAsState()
    val rotaAtual = currentBack?.destination?.route ?: PlannerRotas.TELA_UM_ROTA

    val ehRotaUm = rotaAtual == PlannerRotas.TELA_UM_ROTA
    val ehRotaDois = rotaAtual == PlannerRotas.TELA_DOIS_ROTA
    val ehRotaTres = rotaAtual == PlannerRotas.TELA_TRES_ROTA

    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color.White)
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        TextButton(colors = ButtonDefaults.buttonColors(
            containerColor = getColorMenu(ehRotaUm)
        ),
            onClick = {
                navController.navigate(PlannerRotas.TELA_UM_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {

            Icon(
                painter = painterResource(id = R.drawable.checklist),
                //imageVector = Icons.Default.Call,
                contentDescription = "C",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaUm)
            )
            Text(text = "Tela 1", fontSize = 30.sp,
                color = getColorTexto(ehRotaUm)
            )
        }

        TextButton(colors = ButtonDefaults.buttonColors(
            containerColor = getColorMenu(ehRotaDois)),
            onClick = {
                navController.navigate(PlannerRotas.TELA_DOIS_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {

            Icon(
                painter = painterResource(id = R.drawable.checklist),
                //imageVector = Icons.Default.Call,
                contentDescription = "C",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaDois)
            )
            Text(text = "Tela 2", fontSize = 30.sp,
                color = getColorTexto(ehRotaDois)
            )
        }

        TextButton(colors = ButtonDefaults.buttonColors(
            containerColor = getColorMenu(ehRotaTres)),
            onClick = {
                navController.navigate(PlannerRotas.TELA_TRES_ROTA)
                coroutineScope.launch {
                    drawerState.close()
                }
            }) {

            Icon(
                painter = painterResource(id = R.drawable.checklist),
                //imageVector = Icons.Default.Call,
                contentDescription = "C",
                modifier = Modifier.size(40.dp),
                tint = getColorTexto(ehRotaTres)
            )
            Text(text = "Tela 3", fontSize = 30.sp,
                color = getColorTexto(ehRotaTres)
            )
        }


    }
}
fun getColorTexto(estateSelecionada: Boolean): Color {
    if(estateSelecionada){
        return Color.White
    }else{
        return Color.Black
    }
}


fun getColorMenu(estateSelecionada: Boolean): Color {
    if(estateSelecionada){
        return Color(0xFF39A1E7)
    }else{
        return Color.Transparent
    }
}
