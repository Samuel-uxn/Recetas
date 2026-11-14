package com.aplications.recetas.presentation.view


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun ScreenSeleccionarIngredientes(
    onBuscarClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    var busqueda by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("SELECCIONA TUS", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("INGREDIENTES", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Bienvenido", fontSize = 16.sp, modifier = Modifier.padding(vertical = 10.dp))

        OutlinedTextField(
            value = busqueda,
            onValueChange = { busqueda = it },
            label = { Text("Busca tu ingrediente:") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {  }, modifier = Modifier.size(120.dp, 60.dp)) {
                Text("Papa")
            }
            Button(onClick = {  }, modifier = Modifier.size(120.dp, 60.dp)) {
                Text("Arroz")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {  }, modifier = Modifier.size(120.dp, 60.dp)) {
                Text("Pasta")
            }
            Button(onClick = {  }, modifier = Modifier.size(120.dp, 60.dp)) {
                Text("Pollo")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { onBuscarClick() },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Buscar recetas", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = { onBackClick() }, modifier = Modifier.fillMaxWidth()) {
            Text("Atras")
        }
    }
}