package com.example.taller2eventos

import NetworkTask
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taller2eventos.ui.theme.Taller2EventosTheme
import java.util.Calendar

// Clase principal de la actividad
class PantallaInicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita el modo de borde a borde
        setContent {
            Taller2EventosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val mensaje = mensajeDeBienvenida() // Obtiene el mensaje de bienvenida
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray)
                            .padding(innerPadding)
                            .wrapContentSize()
                    ) {
                        // Muestra el mensaje de bienvenida
                        Text(
                            text = mensaje,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                        Spacer(modifier = Modifier.height(25.dp)) // Espacio entre elementos
                        // Botón para continuar a la siguiente actividad
                        Button(
                            onClick = {
                                val intent = Intent(this@PantallaInicio, ActividadPrincipal::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text("Continuar")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun pantallaPrincipal() {
    val context = LocalContext.current

    Taller2EventosTheme {
        val mensaje = mensajeDeBienvenida() // Obtiene el mensaje de bienvenida
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .wrapContentSize()
        ) {
            // Muestra el mensaje de bienvenida
            Text(
                text = mensaje,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(25.dp)) // Espacio entre elementos
            // Botón para continuar (sin acción definida en la vista previa)
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Continuar")
            }
            Spacer(modifier = Modifier.height(25.dp)) // Espacio entre elementos
            // Botón para iniciar la tarea en segundo plano
            Button(
                onClick = {
                    NetworkTask(context).execute()
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Iniciar Tarea en Segundo Plano")
            }
        }
    }
}

// Función que devuelve un mensaje de bienvenida basado en la hora del día
@Composable
fun mensajeDeBienvenida(): String {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 6..12 -> "Buenos días"
        in 13..19 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}

// Función composable para mostrar un saludo con un nombre
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}