package com.example.taller2eventos

import NetworkTask
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.taller2eventos.PantallaConfiguracion
import com.example.taller2eventos.ui.theme.Taller2EventosTheme

// Clase principal de la actividad
class ActividadPrincipal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller2EventosTheme {
                SegundaPantalla() // Llama a la función composable para mostrar la segunda pantalla
            }
        }
    }
}
@Composable
fun SegundaPantalla() {
    var name by remember { mutableStateOf("") } // Estado para almacenar el nombre ingresado
    var savedName by remember { mutableStateOf("") } // Estado para almacenar el nombre guardado
    var showDialog by remember { mutableStateOf(false) } // Estado para controlar la visibilidad del diálogo
    val context = LocalContext.current // Contexto actual

    // Mostrar un diálogo de alerta si showDialog es verdadero
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Error") },
            text = { Text("Debe ingresar un nombre") }
        )
    }

    // Columna que contiene todos los elementos de la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(16.dp)
    ) {
        // Campo de texto para ingresar el nombre
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ingrese su nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos
        // Botón para guardar el nombre ingresado
        Button(
            onClick = { savedName = name },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Nombre")
        }
        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos
        // Texto que muestra el nombre guardado
        Text(
            text = "Nombre guardado: $savedName",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos
        // Botón para ir a la pantalla de configuración
        Button(
            onClick = {
                if (savedName.isNotEmpty()) {
                    val intent = Intent(context, PantallaConfiguracion::class.java)
                    context.startActivity(intent)
                } else {
                    showDialog = true // Mostrar diálogo si no se ha guardado un nombre
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Tercera Pantalla")
        }
        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos
        // Botón para iniciar la tarea en segundo plano
        Button(
            onClick = {
                NetworkTask(context).execute()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Tarea en Segundo Plano")
        }
    }
}

// Función de vista previa para la segunda pantalla
@Preview(showBackground = true)
@Composable
fun SegundaPantallaPreview() {
    Taller2EventosTheme   {
        SegundaPantalla()
    }
}