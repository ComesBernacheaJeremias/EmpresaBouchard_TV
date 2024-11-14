package com.example.empresabouchard_tv

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.empresabouchard_tv.ui.theme.EmpresaBouchard_TVTheme
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Firebase.firestore
        //Obtener datos
        val docRef = db.collection("persona").document("111821")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.i("Corcho","DocumentSnapshot data: ${document.data}")
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
                    InitUI()
                }
            }
        }
    }
}


@Composable
fun InitUI(){



    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth(), contentAlignment = Alignment.Center
        ){Text("Nombre del fallecido")}
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
                    Text("botones", modifier = Modifier.weight(1f))
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Text("LOGO")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmpresaBouchard_TVTheme {
       InitUI()
    }
}