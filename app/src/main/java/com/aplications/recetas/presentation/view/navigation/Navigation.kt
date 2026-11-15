package com.aplications.recetas.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aplications.recetas.presentation.view.ScreenCrearReceta
import com.aplications.recetas.presentation.view.ScreenDetalleReceta
import com.aplications.recetas.presentation.view.ScreenInicio
import com.aplications.recetas.presentation.view.ScreenLogin
import com.aplications.recetas.presentation.view.ScreenSeleccionarIngredientes
import com.aplications.recetas.presentation.viewmodel.AuthViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.aplications.recetas.presentation.view.ScreenRegistro

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            val vm: AuthViewModel = viewModel()
            val state by vm.state.collectAsState()
            LaunchedEffect(state.success) {
                if (state.success){
                    navController.navigate("inicio"){
                        popUpTo("login"){
                            inclusive=true
                        }
                    }
                }
            }
            ScreenLogin(
                onLoginClick = {email, password -> vm.login(email, password) },
                onRegistroClick = {navController.navigate("registro")},
                loading = state.loading,
                error = state.error
            )
        }
        composable("registro") {
            val vm: AuthViewModel = viewModel()
            val state by vm.state.collectAsState()

            LaunchedEffect(state.success) {
                if (state.success) {
                    navController.navigate("inicio") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }

            ScreenRegistro(
                onRegisterClick = { nombre, email, pass -> vm.register(nombre, email, pass) },
                onLoginClick = { navController.popBackStack() },
                loading = state.loading,
                error = state.error
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
                onBuscarClick = { navController.navigate("inicio") },
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