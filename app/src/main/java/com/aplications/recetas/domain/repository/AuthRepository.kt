package com.aplications.recetas.domain.repository

import com.aplications.recetas.domain.model.User

interface AuthRepository{
    suspend fun register(name: String, email: String, password: String): Result<User>
    suspend fun login(email: String, password: String): Result<User>
    fun currentUser():User?
    fun logouth()
}