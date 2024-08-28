package br.edu.up.exmaterial.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TerceriaScreen(titulo: String, modifier: Modifier = Modifier) {
    Text(
        text = titulo,
        modifier = modifier
    )
}