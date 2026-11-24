package com.baism.cw2

import com.baism.cw2.PasswordValidator.Strength
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun shortPassword_isWeak() {
        assertEquals(Strength.WEAK, PasswordValidator.strength("Ab1!"))
    }

    @Test
    fun lettersOnly_isMedium() {
        assertEquals(Strength.MEDIUM, PasswordValidator.strength("abcdefGH"))
    }

    @Test
    fun allCharacterClasses_isStrong() {
        assertEquals(Strength.STRONG, PasswordValidator.strength("Abcdef1!"))
    }

    @Test
    fun weakPassword_isNotAcceptable() {
        assertFalse(PasswordValidator.isAcceptable("12345"))
    }

    @Test
    fun strongPassword_isAcceptable() {
        assertTrue(PasswordValidator.isAcceptable("Str0ng&Passw0rd"))
    }
}
