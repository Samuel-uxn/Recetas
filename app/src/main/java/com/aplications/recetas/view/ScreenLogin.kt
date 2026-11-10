package com.aplications.recetas.view

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.aplications.recetas.R

@Preview(showSystemUi = true)
@Composable
fun ScreenLogin(onLoginClick:()-> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFD1E0D1))
        .padding(34.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("ColSoup", fontSize = 30.sp, fontWeight = FontWeight.Bold )
            Text("Inicia sesion en tu cuenta")

            Spacer(modifier = Modifier.height(30.dp))
            Column() {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {Text("Correo electronico")},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {Text("Ingresa tu contraseña")},
                    modifier = Modifier.fillMaxWidth()
                )
                Text("¿Olvidaste tu contraseña?", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(55.dp)) {
                    Text("Iniciar sesion", textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())
                }
                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "o",
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )

                    HorizontalDivider(
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth().height(55.dp)) {
                    Image(painter = painterResource(id = R.drawable.google),
                        contentDescription = "Logo de Google",
                        modifier = Modifier.size(24.dp))

                    Spacer(modifier = Modifier.width(12.dp))

                    Text("Continuar con Google")
                }
            }

       }
        Button(onClick = { onLoginClick() }, modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .align(Alignment.BottomCenter)) {
            Text("Crear nueva cuenta",)
        }
    }
}