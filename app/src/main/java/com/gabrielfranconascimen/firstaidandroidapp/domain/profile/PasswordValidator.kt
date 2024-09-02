package com.gabrielfranconascimen.firstaidandroidapp.domain.profile

import java.util.regex.Pattern

interface PasswordValidator {
    fun execute(text: String): Boolean
}

class PasswordValidatorImpl: PasswordValidator {

    override fun execute(text: String): Boolean {
        return atLeastOneCapitalLetter(text) &&
                atLeastOneLowercaseLetter(text) &&
                atLeastOneDigit(text) &&
                atLeastOneSpecialCharacter(text) &&
                atLeastEightCharacters(text)
    }


    private fun atLeastOneCapitalLetter(value: String) : Boolean {
        val regex = Pattern.compile(".*[A-Z].*")
        return regex.matcher(value).matches()
    }

    private fun atLeastOneLowercaseLetter(value: String): Boolean {
        val regex = Pattern.compile(".*[a-z].*")
        return regex.matcher(value).matches()
    }

    private fun atLeastOneDigit(value: String): Boolean {
        val regex = Pattern.compile(".*[0-9].*")
        return regex.matcher(value).matches()
    }

    private fun atLeastOneSpecialCharacter(value: String) : Boolean {
        val regex = Pattern.compile(".*[!@#$%&+?*-].*")
        return regex.matcher(value).matches()
    }

    private fun atLeastEightCharacters(value: String): Boolean {
        val regex = Pattern.compile("^(?=\\S+$).{8,}$")
        return regex.matcher(value).matches()
    }

}