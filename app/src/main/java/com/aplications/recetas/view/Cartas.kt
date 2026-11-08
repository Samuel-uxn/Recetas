package com.aplications.recetas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aplications.recetas.R
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.items
// 1. Primero, creamos una estructura de datos falsa (Mock) para jugar
data class RecetaPrueba(
    val id: Int,
    val titulo: String,
    val tiempo: String,
    val dificultad: String,
    val imagenRes: Int // Aquí iría el R.drawable.tu_foto
)

@Preview(showSystemUi = true)
@Composable
fun PantallaCatalogo() {
    // 2. Armamos nuestra lista de 2 recetas quemadas en el código
    val listaRecetas = listOf(
        RecetaPrueba(1, "Arroz con Pollo", "45 min", "Fácil", R.drawable.arrozpollo),
        RecetaPrueba(2, "Bandeja Paisa", "50 min", "Medio", R.drawable.paisa)
    )

    // 3. ¡Magia! El LazyColumn recorre la lista y crea las tarjetas
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp) // Da un respiro al final del scroll
    ) {
        // La función items() toma tu lista y te entrega un elemento a la vez
        items(listaRecetas) { recetaActual ->
            TarjetaReceta(
                titulo = recetaActual.titulo,
                info = "${recetaActual.tiempo} • ${recetaActual.dificultad}",
                onClick = {
                    println("Tocaste la receta: ${recetaActual.titulo}")
                }
            )
        }
    }
}

// 4. Tu componente visual ahora recibe los datos como parámetros
@Composable
fun TarjetaReceta(
    titulo: String,
    info: String,
    onClick: () -> Unit // Parámetro para manejar el toque
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp) // Separación entre tarjetas
            .clickable { onClick() }, // ¡Así se hace clickeable toda la tarjeta!
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // El recuadro gris simula la imagen por ahora si no tienes fotos
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(Color.LightGray)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = titulo, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = info, color = Color.Gray)
            }
        }
    }
}