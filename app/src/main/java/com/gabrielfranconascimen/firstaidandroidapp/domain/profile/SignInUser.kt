package com.gabrielfranconascimen.firstaidandroidapp.domain.profile

import com.gabrielfranconascimen.firstaidandroidapp.common.network.FADispatcher
import com.gabrielfranconascimen.firstaidandroidapp.data.signin.SignInRepository
import kotlinx.coroutines.withContext

interface SignInUser {
    suspend fun execute(email: String, password: String): String?
}

class SignInUserImpl(
    private val authRepository: SignInRepository,
    private val dispatchers: FADispatcher
) : SignInUser {
    override suspend fun execute(email: String, password: String): String? = withContext(dispatchers.io) {
        authRepository.signIn(email, password)
    }
}