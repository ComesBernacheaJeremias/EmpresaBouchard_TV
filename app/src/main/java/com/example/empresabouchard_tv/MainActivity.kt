package com.example.empresabouchard_tv

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.empresabouchard_tv.ui.InicioUI
import com.example.empresabouchard_tv.ui.theme.EmpresaBouchard_TVTheme
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Firebase.firestore

        //Obtener todos los documentos
        db.collection("persona")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                 //   Log.i("Corcho", "${document.id} => ${document.data}")
                //    Log.i("Corcho", "Nombre del fallecido: ${document.getString("Nombre")}")

                }

            }
            .addOnFailureListener { exception ->
                Log.i("Corcho", "Error getting documents: ", exception)
            }





        //Obtener datos de documento
        val docRef = db.collection("persona").document("Nombre del Fallecido ")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                   // Log.i("Corcho","DocumentSnapshot data: ${document.data}")
                    //Obtener solo un dato
                    val nombre = document.getString("Dato1")
                  //  Log.i("Corcho","Solo Nombre del fallecido: $nombre")
                } else {
                    Log.d("Corcho", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Corcho", "get failed with ", exception)
            }

        setContent {
            EmpresaBouchard_TVTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    //InitUI()
                   // InicioUI()
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController() // Inicializa el NavController

    // Define el NavHost
    NavHost(
        navController = navController,
        startDestination = "home" // Pantalla inicial
    ) {
        // Pantalla "Home"
        composable("home") {
            InicioUI(navController)
        }

        // Pantalla "Details"
        composable("datos/{nombre}") { DetailsScreen(navController)
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun DetailsScreen(navController: NavController, Nombre: String? = null) {

    var nombre = mutableStateOf<String>("")
    var apellido = mutableStateOf<String>("")
    var dato1 = mutableStateOf<String>("")
    var dato2 = mutableStateOf<String>("")
    var dato3 = mutableStateOf<String>("")
    var dato4 = mutableStateOf<String>("")


    val db = Firebase.firestore
    //Obtener datos de documento
    val docRef = db.collection("persona").document(Nombre.toString())
    docRef.get()
        .addOnSuccessListener { document ->
            if (document != null) {
                Log.i("Corcho", "DocumentSnapshot data: ${document.data}")
                //Obtener solo un dato
                 nombre.value = document.getString("Nombre") ?: "Nombre desconocido"

                Log.i("Corcho", "Solo Nombre del fallecido: $nombre")
            } else {
                Log.d("Corcho", "No such document")
            }
        }
        .addOnFailureListener { exception ->
            Log.d("Corcho", "get failed with ", exception)
        }




    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth(), contentAlignment = Alignment.Center
        ){Text(nombre.value)}
        Spacer(modifier = Modifier.height(10.dp))
        Box {
            Column {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.height(40.dp).width(100.dp)) {
                        Text("IMAGEN")
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(modifier = Modifier.height(40.dp).weight(1f)) {
                        Text("mensajes")
                    }
                }
                Row {
                    Text("botones", modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("botones", modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(Nombre.toString(), modifier = Modifier.weight(1f))
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Text("LOGO")
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmpresaBouchard_TVTheme {
       InitUI()
    }
}*/