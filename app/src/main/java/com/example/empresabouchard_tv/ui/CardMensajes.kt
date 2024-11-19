package com.example.empresabouchard_tv.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.* // Para Column, Row, Spacer, Modifier.fillMaxWidth, etc.
import androidx.compose.material3.Card
import androidx.compose.ui.Modifier // Para modificadores como fillMaxWidth, padding, etc.
import androidx.compose.ui.text.font.FontWeight // Para definir la negrita en Text
import androidx.compose.ui.text.style.TextOverflow // Para manejar el desbordamiento del texto
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // Para medidas como padding y height
import androidx.compose.ui.unit.sp // Para tamaños de fuente
import com.example.empresabouchard_tv.ui.theme.EmpresaBouchard_TVTheme
import com.example.empresabouchard_tv.ui.theme.LogoColor


@Composable
fun CardMensajes() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(2.dp, color = LogoColor, shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Nombre y apellido
            Text(
                text = "nombre apellido",
                fontWeight = FontWeight.Bold, // Negrita
                fontSize = 40.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Mensaje
            Text(
                text = "mensaje aklsaklsd asdkjalskjdj askldja lksdjakls djaklsjdl alskdjal skdjalk sdjlaks djlkjkljklja sdkljlk jklj asdklja sdkljasldkjasdlkalksdja ",
                fontSize = 30.sp,
                maxLines = 3, // Limita a 3 líneas
                overflow = TextOverflow.Ellipsis // Muestra "..." si supera el límite
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmpresaBouchard_TVTheme {
       CardMensajes()
    }
}