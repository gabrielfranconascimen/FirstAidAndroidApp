package com.gabrielfranconascimen.firstaidandroidapp.domain.profile

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    private val passwordValidator = PasswordValidatorImpl()

    @Test
    fun `Password valid`() {
        val isValid = passwordValidator.execute("!Abcd1234")

        assertTrue(isValid)
    }

    @Test
    fun `Password invalid because a upper letter is missing`() {
        val isValid = passwordValidator.execute("!abcd1234")

        assertFalse(isValid)
    }

    @Test
    fun `Password invalid because a lower letter is missing`() {
        val isValid = passwordValidator.execute("!ABCD1234")

        assertFalse(isValid)
    }

    @Test
    fun `Password invalid because a number is missing`() {
        val isValid = passwordValidator.execute("!abcdABCD")

        assertFalse(isValid)
    }

    @Test
    fun `Password invalid because a special character is missing`() {
        val isValid = passwordValidator.execute("Abcd1234")

        assertFalse(isValid)
    }

    @Test
    fun `Password invalid because a eight character missing`() {
        val isValid = passwordValidator.execute("a!b12")

        assertFalse(isValid)
    }
}