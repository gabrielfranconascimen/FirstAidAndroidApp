package com.gabrielfranconascimen.firstaidandroidapp.domain.profile

import com.gabrielfranconascimen.firstaidandroidapp.data.signin.SignInRepository

class GetUser(
    private val authRepository: SignInRepository,
) {
    fun isLogged(): Boolean {
        return authRepository.isLogged()
    }
}