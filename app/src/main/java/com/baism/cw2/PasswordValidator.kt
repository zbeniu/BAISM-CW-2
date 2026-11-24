package com.baism.cw2

/** Prosta logika biznesowa testowana jednostkowo w pipeline CI/CD (Bitrise). */
object PasswordValidator {

    const val MIN_LENGTH = 8

    enum class Strength { WEAK, MEDIUM, STRONG }

    fun strength(password: String): Strength {
        if (password.length < MIN_LENGTH) return Strength.WEAK
        var score = 0
        if (password.any { it.isLowerCase() }) score++
        if (password.any { it.isUpperCase() }) score++
        if (password.any { it.isDigit() }) score++
        if (password.any { !it.isLetterOrDigit() }) score++
        return when {
            score >= 4 -> Strength.STRONG
            score >= 2 -> Strength.MEDIUM
            else -> Strength.WEAK
        }
    }

    fun isAcceptable(password: String): Boolean = strength(password) != Strength.WEAK
}
