package com.example.empresabouchard_tv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Text
import com.example.empresabouchard_tv.R
import com.example.empresabouchard_tv.ui.theme.EmpresaBouchard_TVTheme
@Composable
fun Prueba() {
    val customFontFamily = FontFamily(
        Font(R.font.inriaserif_normal) // Define la fuente desde tus recursos
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título centrado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Título Principal",
                fontSize = 50.sp,
                fontFamily = customFontFamily,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        // Sección de imagen y mensajes
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Imagen a la izquierda
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight()
                    .padding(end = 16.dp)
            ) {
                Text(
                    text = "IMAGEN",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray)
                        .padding(8.dp),
                    color = Color.White
                )
            }

            // Mensajes (lista simulada)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
                    .background(Color.LightGray)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Mensajes Recibidos",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                for (i in 1..5) { // Simulando mensajes
                    Text(
                        text = "Mensaje $i: Este es el contenido del mensaje.",
                        fontSize = 30.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Sección de subtítulos
        Row {
            Text("dato1: 17:00",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontFamily = customFontFamily,
                modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(4.dp))
            Text("dato2: 19:30",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontFamily = customFontFamily,
                modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(4.dp))
            Text("dato3: 20:00",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontFamily = customFontFamily,
                modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Logo en la parte inferior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 16.dp)
                .background(Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "LOGO",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmpresaBouchard_TVTheme {
        Prueba()
    }
}*/