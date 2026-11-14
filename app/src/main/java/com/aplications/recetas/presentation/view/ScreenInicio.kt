package com.aplications.recetas.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aplications.recetas.R
import com.aplications.recetas.domain.model.Receta
import com.aplications.recetas.presentation.view.componente.TarjetaReceta

@Composable
fun ScreenInicio(
    onRecetaClick: () -> Unit,
    onCrearClick: () -> Unit,
    onBuscarClick: () -> Unit
) {
    val listaRecetas = listOf(
        Receta(1, "Arroz con Pollo", "45 minutos", "Facil", R.drawable.arrozpollo),
        Receta(2, "Bandeja Paisa", "45 minutos", "Facil", R.drawable.paisa),
        Receta(3, "Pasta Alfredo", "45 minutos", "Facil", R.drawable.pasta_alfredo)
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text("ColSoup", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onBuscarClick() }) {
                Text("Buscar Ingredientes")
            }
            Button(onClick = { onCrearClick() }) {
                Text("Mis Creaciones")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(listaRecetas) { recetaActual ->
                TarjetaReceta(
                    titulo = recetaActual.titulo,
                    info = "${recetaActual.tiempo} - ${recetaActual.dificultad}",
                    imagenId = recetaActual.imagenRes,
                    onClick = { onRecetaClick() }
                )
            }
        }

    }
}