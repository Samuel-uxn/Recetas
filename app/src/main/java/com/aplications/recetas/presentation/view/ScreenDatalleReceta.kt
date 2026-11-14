package com.aplications.recetas.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aplications.recetas.R

@Composable
fun ScreenDetalleReceta(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrozpollo),
            contentDescription = "Foto de la receta",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(20.dp)) {
            Text("Arroz con Pollo", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Ingredientes:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "• 500g Pollo desmenuzado\n• 2 tazas de Arroz\n• 1 taza de Arvejas, Zanahoria y Habichuela\n• Condimentos al gusto (color, sal, ajo)\n• 1 taza de caldo de pollo",
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                fontSize = 16.sp
            )

            Text("Preparación:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "1. En una olla, sofríe las verduras picadas con un poco de aceite y ajo.\n2. Agrega el arroz y revuelve por 2 minutos para sellarlo.\n3. Incorpora el pollo desmenuzado, el caldo de pollo y el color.\n4. Deja hervir a fuego alto hasta que el agua se evapore.\n5. Tapa la olla, baja el fuego al mínimo y deja cocinar por 20 minutos.",
                modifier = Modifier.padding(top = 8.dp, bottom = 24.dp),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { onBackClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Volver al Inicio", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}