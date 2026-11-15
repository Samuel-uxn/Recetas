package com.aplications.recetas.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplications.recetas.data.repository.AuthRepositoryImpl
import com.aplications.recetas.domain.model.User
import com.aplications.recetas.domain.repository.AuthRepository
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class AuthState(
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

class AuthViewModel(
    private val repository: AuthRepository = AuthRepositoryImpl()
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state

    fun register(nombre: String, email: String, pass: String) =
        launchAuth { repository.register(nombre, email, pass) }

    fun login(email: String, pass: String) =
        launchAuth { repository.login(email, pass) }

    private fun launchAuth(call: suspend () -> Result<User>) {
        viewModelScope.launch {
            _state.value = AuthState(loading = true)
            call()
                .onSuccess { _state.value = AuthState(success = true) }
                .onFailure { _state.value = AuthState(error = traducir(it)) }
        }
    }
    private fun
traducir(e: Throwable) = when (e) {
        is FirebaseAuthUserCollisionException -> "Ese correo ya está registrado"
        is FirebaseAuthWeakPasswordException -> "La contraseña es muy débil"
        is FirebaseAuthInvalidCredentialsException -> "Correo o contraseña incorrectos"
        is FirebaseAuthInvalidUserException -> "No existe una cuenta con ese correo"
        is FirebaseNetworkException -> "Sin conexión a internet"
        else -> e.message ?: "Ocurrió un error"
    }
}