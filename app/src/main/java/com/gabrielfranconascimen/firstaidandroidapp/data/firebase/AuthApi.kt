package com.gabrielfranconascimen.firstaidandroidapp.data.firebase

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine

class AuthApi {

    private val auth = Firebase.auth

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun signIn(email: String, password: String): String? {
        return suspendCancellableCoroutine { continuation ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { result ->
                    continuation.resume(result.user?.uid, null)
                }
                .addOnFailureListener {
                    continuation.resume(null, null)
                }
        }
    }

    fun logOut() {
        auth.signOut()
    }

    fun isLogged(): Boolean {
        return auth.currentUser != null
    }
}