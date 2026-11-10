package com.aplications.recetas.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aplications.recetas.view.ScreenCrearReceta
import com.aplications.recetas.view.ScreenDetalleReceta
import com.aplications.recetas.view.ScreenInicio
import com.aplications.recetas.view.ScreenLogin
import com.aplications.recetas.view.ScreenSeleccionarIngredientes

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            ScreenLogin(
                onLoginClick = { navController.navigate("inicio") }
            )
        }
        composable("crear") {
            ScreenCrearReceta(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("detalle") {
            ScreenDetalleReceta(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("buscar") {
            ScreenSeleccionarIngredientes(
                onBuscarClick = { navController.navigate("inicio") }, // Lo devolvemos al inicio como prueba
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("inicio") {
            ScreenInicio(
                onRecetaClick = { navController.navigate("detalle") },
                onCrearClick = { navController.navigate("crear") },
                onBuscarClick = { navController.navigate("buscar") }
            )
        }
    }
}