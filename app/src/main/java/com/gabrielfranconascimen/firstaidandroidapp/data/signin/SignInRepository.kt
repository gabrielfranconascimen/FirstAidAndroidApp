package com.gabrielfranconascimen.firstaidandroidapp.data.signin

import com.gabrielfranconascimen.firstaidandroidapp.data.firebase.AuthApi

interface SignInRepository {
    suspend fun signIn(email: String, password: String): String?
    fun logOut()
    fun isLogged(): Boolean
}

class SignInRepositoryImpl(
    private val authApi: AuthApi
) : SignInRepository {

    override suspend fun signIn(email: String, password: String): String? {
        return authApi.signIn(email, password)
    }

    override fun logOut() {
        authApi.logOut()
    }

    override fun isLogged(): Boolean {
        return authApi.isLogged()
    }
}