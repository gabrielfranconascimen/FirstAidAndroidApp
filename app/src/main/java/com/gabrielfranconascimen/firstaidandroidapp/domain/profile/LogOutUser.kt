package com.gabrielfranconascimen.firstaidandroidapp.domain.profile

import com.gabrielfranconascimen.firstaidandroidapp.data.signin.SignInRepository

interface LogOutUser {
    fun execute()
}

class LogOutUserImpl(
    private val authRepository: SignInRepository,
): LogOutUser {

    override fun execute() {
        authRepository.logOut()
    }

}