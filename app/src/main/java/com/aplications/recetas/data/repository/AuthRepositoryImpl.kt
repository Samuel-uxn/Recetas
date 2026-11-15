package com.aplications.recetas.data.repository

import com.aplications.recetas.data.remote.AuthFirebaseDataSource
import com.aplications.recetas.domain.model.User
import com.aplications.recetas.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser

class AuthRepositoryImpl(private val datasource: AuthFirebaseDataSource = AuthFirebaseDataSource()):AuthRepository {
    private fun FirebaseUser?.toDomain(): User =
        this?.let { User(it.uid, it.email, it.displayName) }
            ?:throw Exception("Usuario no encontrado")

    override suspend fun register(name: String, email: String, password: String) = runCatching {
        datasource.regitro(name, email, password).toDomain()
    }

    override suspend fun login(email: String, password: String) = runCatching {
        datasource.login(email, password).toDomain()
    }

    override fun currentUser() = datasource.currentUser()?.let { User(it.uid, it.email, it.displayName) }
    override fun logout() = datasource.logout()
}