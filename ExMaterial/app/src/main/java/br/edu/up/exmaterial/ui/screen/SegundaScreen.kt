package br.edu.up.exmaterial.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.exmaterial.R
import br.edu.up.exmaterial.ui.theme.Purple80

@Composable
fun SegundaScreen(titulo: String, modifier: Modifier = Modifier) {
    Layout()
//    Text(
//        text = titulo,
//        modifier = modifier
//    )
}
//@Preview(
//    device = Devices.PIXEL
//)
//@Composable
//fun Layout(){
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .background(Color(0xFFFFF9C5))) {
//
//        Row(modifier = Modifier.weight(1f)
//            .fillMaxWidth()
//            .background(Color.Gray))
//        {
//
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .width(100.dp)
//                .height(50.dp)
//                .background(Purple80)){
//
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .width(100.dp)
//                .height(50.dp)
//                .background(Color.Blue)){
//
//            }
//        }
//
//        Row(modifier = Modifier.weight(1f)
//            .fillMaxWidth()
//            .background(Color.LightGray))
//        {
//
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .width(100.dp)
//                .height(50.dp)
//                .background(Color.Magenta)){
//
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .width(100.dp)
//                .height(50.dp)
//                .background(Color.Cyan)){
//
//            }
//        }
//
//    }

@Preview(
    device = Devices.PIXEL
)
//@Composable
//fun Layout(){
//    Column(modifier = Modifier.fillMaxSize()) {
//        Row (modifier = Modifier.weight(1f)){
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .weight(3f)
//                .background(Color.Red)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Green)){
//            }
//        }
//
//        Row(modifier = Modifier.weight(1f)){
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .weight(2f)
//                .background(Color.Red)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Blue)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Yellow)){
//            }
//        }
//
//        Row(modifier = Modifier.weight(1f)){
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Red)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Green)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .weight(2f)
//                .background(Color.Yellow)){
//            }
//        }
//
//        Row(modifier = Modifier.weight(1f)){
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Blue)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .weight(3f)
//                .background(Color.Yellow)){
//            }
//        }
//
//        Row(modifier = Modifier.weight(1f)){
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .weight(2f)
//                .background(Color.Green)){
//            }
//
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Red)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Yellow)){
//            }
//        }
//
//        Row(modifier = Modifier.weight(1f)){
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .fillMaxWidth()
//                .weight(3f)
//                .background(Color.Green)){
//            }
//            Box(modifier = Modifier
//                .fillMaxHeight()
//                .weight(1f)
//                .background(Color.Blue)){
//            }
//        }
//    }
//}
@Composable
fun Layout(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Row(modifier = Modifier
            .background(Color.Red)
            .weight(1f)) {
            Column(modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)){
                    Image(painter = painterResource(id = R.drawable.travis),
                        contentDescription = "Foto", modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Companion.FillHeight)
                }
            }
            Column(modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    )
                {
                    Column {
                        Row(modifier = Modifier.weight(1f)) {
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Red)){
                            }
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Green)){
                            }
                        }
                        Row (modifier = Modifier.weight(1f)){
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Blue)){
                            }
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Yellow)){
                            }

                        }
                    }
                }
            }
        }

        Row(modifier = Modifier
            .background(Color.Yellow)
            .weight(1f)) {
            Column(modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    ){
                    Column {
                        Row(modifier = Modifier.weight(1f)) {
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Red)){
                            }
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Green)){
                            }
                        }
                        Row (modifier = Modifier.weight(1f)){
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Blue)){
                            }
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Yellow)){
                            }

                        }
                    }
                }

            }
            Column(modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)){
                    Image(painter = painterResource(id = R.drawable.kendrick),
                        contentDescription = "Foto", modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Companion.FillHeight)

                }
            }
        }

        Row(modifier = Modifier
            .background(Color.Green)
            .weight(1f)) {
            Column(modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)){
                    Image(painter = painterResource(id = R.drawable.dontoliver),
                        contentDescription = "Foto", modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Companion.FillHeight)
                }
            }
            Column(modifier = Modifier.weight(1f)){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    ){
                    Column {
                        Row(modifier = Modifier.weight(1f)) {
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Red)){
                            }
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Yellow)){
                            }
                        }
                        Row (modifier = Modifier.weight(1f)){
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Green)){
                            }
                            Box(modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .weight(1f)
                                .background(Color.Blue)){
                            }

                        }
                    }
                }
            }
        }

    }
}