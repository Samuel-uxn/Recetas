package com.aplications.recetas.data.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await

class AuthFirebaseDataSource(private val auth: FirebaseAuth = FirebaseAuth.getInstance()){
    suspend fun regitro(name: String, email: String, password: String): FirebaseUser?{
        val user = auth.createUserWithEmailAndPassword(email, password).await().user

        user?.updateProfile(
            UserProfileChangeRequest.Builder().setDisplayName(name).build()
        )?.await()
        return user
    }

    suspend fun login(email: String, password: String): FirebaseUser? =
        auth.signInWithEmailAndPassword(email, password).await().user

    fun currentUser(): FirebaseUser? = auth.currentUser
    fun logout() = auth.signOut()
}
