package com.gabrielfranconascimen.firstaidandroidapp.domain.profile

import android.util.Patterns

interface EmailValidator {
    fun execute(text: String): Boolean
}

class EmailValidatorImpl: EmailValidator {

    override fun execute(text: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }

}