package com.aplications.recetas.presentation.view

import android.graphics.Color.red
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.aplications.recetas.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun ScreenLogin(
    onLoginClick:(email: String, password: String)-> Unit ={_,_->},
    onRegistroClick:()-> Unit={},
    onGoogleClick:()-> Unit={},
    loading: Boolean = false,
    error: String? = null
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorLocal by remember { mutableStateOf<String?>(null) }


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
                    value = email,
                    onValueChange = {email = it},
                    label = {Text("Correo electronico")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    label = {Text("Ingresa tu contraseña")},
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                (errorLocal?: error)?.let {
                    Text(
                        it,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                    )
                }
                Text(
                    "¿Olvidaste tu contraseña?", textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        errorLocal = if(email.isBlank()|| password.isBlank())
                            "Completa todos los campos" else null
                        if (errorLocal == null)
                            onLoginClick(email.trim(),password)
                    },
                    enabled = !loading,
                    modifier = Modifier.fillMaxWidth().height(55.dp))
                {
                    if(loading){
                        CircularProgressIndicator(modifier = Modifier.size(24.dp), strokeWidth = 2.dp)
                    }else{
                        Text("Iniciar sesion", textAlign = TextAlign.Center)
                    }
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

                OutlinedButton(onClick = onGoogleClick,
                    enabled = !loading,
                    modifier = Modifier.fillMaxWidth().height(55.dp)) {
                    Image(painter = painterResource(id = R.drawable.google),
                        contentDescription = "Logo de Google",
                        modifier = Modifier.size(24.dp))

                    Spacer(modifier = Modifier.width(12.dp))

                    Text("Continuar con Google")
                }
            }

       }
        Button(onClick =  onRegistroClick, modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .align(Alignment.BottomCenter)) {
            Text("Crear nueva cuenta",)
        }
    }
}