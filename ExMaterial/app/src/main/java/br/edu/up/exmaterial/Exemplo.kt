package br.edu.up.exmaterial

import android.health.connect.datatypes.Device
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    device = Devices.PIXEL
)

@Composable
fun ExLayout(){
    Column {
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF2135D6)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically)
        {

            Text(text = "M", modifier = Modifier
                .padding(3.dp)
                .background(Color.White)
                .padding(3.dp)
                .width(20.dp)
                .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = (50.sp))

            Text(text = "I", modifier = Modifier
                .padding(3.dp)
                .background(Color.White)
                .padding(3.dp)
                .width(20.dp)
                .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = (50.sp))

            Text(text = "G", modifier = Modifier
                .padding(3.dp)
                .background(Color.White)
                .padding(3.dp)
                .width(20.dp)
                .weight(1f),
                textAlign = TextAlign.Center,
                fontSize = (50.sp))
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF000000)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
            Texto(txt = "M")
            Texto(txt = "I")
            Texto(txt = "G")
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF4CB434)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically)
        {
            Texto(txt = "M")
            Texto(txt = "I")
            Texto(txt = "G")
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF2135D6)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically)
        {
            Texto(txt = "M")
            Texto(txt = "I")
            Texto(txt = "G")
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF000000))
            , horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically)
        {
            Texto(txt = "M")
            Texto(txt = "I")
            Texto(txt = "G")
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF4CB434)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {
            Texto(txt = "M")
            Texto(txt = "I")
            Texto(txt = "G")
        }
        Row (modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xFF2135D6)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically)
        {
            Texto(txt = "M")
            Texto(txt = "I")
            Texto(txt = "G")
        }

    }
}

@Composable
fun Texto(txt: String){
    Text(text = txt,
        fontSize = 50.sp,
        modifier = Modifier
            .padding(3.dp)
            .background(Color.White)
            .padding(3.dp)
            .width(70.dp),
        textAlign = TextAlign.Center)
}