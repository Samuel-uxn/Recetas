package com.aplications.recetas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun ScreenCrearReceta(onBackClick: () -> Unit = {}) {
    var nombre by remember { mutableStateOf("") }
    var ingredientes by remember { mutableStateOf("") }
    var preparacion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text("Mis Creaciones", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Digite el Nombre de la receta") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = ingredientes,
            onValueChange = { ingredientes = it },
            label = { Text("Escriba el nombre de los ingredientes") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            maxLines = 4
        )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = preparacion,
            onValueChange = { preparacion = it },
            label = { Text("Digite las instrucciones de preparacion") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            maxLines = 5
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { onBackClick() },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Guardar", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(
            onClick = { onBackClick() }, // Botón de Atrás
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Atras", fontSize = 16.sp)
        }
    }
}