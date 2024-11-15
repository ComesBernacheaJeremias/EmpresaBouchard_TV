package com.example.empresabouchard_tv.ui


import android.content.ClipData.Item
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.example.empresabouchard_tv.DetailsScreen
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun InicioUI(navController: NavController) {
    val db = Firebase.firestore

    // Crear un estado para manejar la lista observable
    val listaMutable = remember { mutableStateListOf<String>() }


    // Obtener datos de Firebase
    //Esto asegura que la operación asíncrona se ejecute en un entorno seguro para Compose.
    LaunchedEffect(Unit) {
        db.collection("persona")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.i("Corcho", "${document.id} => ${document.data}")
                    val nombre = document.id
                    //getString("Nombre") ?: "Desconocido"
                    listaMutable.add(nombre)
                }
            }
            .addOnFailureListener { exception ->
                Log.i("Corcho", "Error getting documents: ", exception)
            }
    }


    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Número de columnas
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listaMutable.size) { index -> // Número de elementos en la grilla
            NombresCard(listaMutable[index], navController)
        }
    }

}


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun NombresCard(Nombre: String, navController: NavController) {


    Card(modifier = Modifier
        .height(100.dp)
        .clickable {
            Log.i("Corcho", "Clickitik $Nombre")
            //buscarDatosPrueba(Nombre)
            navController.navigate("datos/$Nombre")
        }, onClick = { Log.i("Corcho", "Click") }) {
        Text(
            text = Nombre,
            modifier = Modifier.padding(16.dp)
        )
    }
}
/*
fun buscarDatosPrueba(Nombre: String) {
    val db = Firebase.firestore
    //Obtener datos de documento
    val docRef = db.collection("persona").document(Nombre)
    docRef.get()
        .addOnSuccessListener { document ->
            if (document != null) {
                Log.i("Corcho", "DocumentSnapshot data: ${document.data}")
                //Obtener solo un dato
                val nombre = document.getString("Dato1")
                Log.i("Corcho", "Solo Nombre del fallecido: $nombre")
            } else {
                Log.d("Corcho", "No such document")
            }
        }
        .addOnFailureListener { exception ->
            Log.d("Corcho", "get failed with ", exception)
        }

}
*/

/*
@Preview(showBackground = true)
@Composable
fun InicioUIPreview() {
    EmpresaBouchard_TVTheme {
        InicioUI()
    }
}*/