package com.example.myapplication0000

import CredentialsManager
import org.junit.Test
import org.junit.Assert.*

class CredentialsManagerTest {

    @Test
    fun whenEmailEmpty_shouldReturnTrue() {
        val checmanager = CredentialsManager()
        assertEquals(true, checmanager.isEmailEmpty(""))
    }

    @Test
    fun whenEmailNotEmpty_shouldReturnFalse() {
        val checmanager = CredentialsManager()
        assertEquals(false, checmanager.isEmailEmpty("test@example.com"))
    }

    @Test
    fun whenEmailInvalid_shouldReturnFalse() {
        val checmanager = CredentialsManager()
        assertEquals(false, checmanager.isEmailValid("invalid-email"))
        assertEquals(false, checmanager.isEmailValid("invalid-email"))
    }

    @Test
    fun whenEmailValid_shouldReturnTrue() {
        val checmanager = CredentialsManager()
        assertEquals(true, checmanager.isEmailValid("valid123@example.com"))
    }

    @Test
    fun whenPasswordEmpty_shouldReturnTrue() {
        val checmanager = CredentialsManager()
        assertEquals(true, checmanager.isPasswordEmpty(""))
    }

    @Test
    fun whenPasswordNotEmpty_shouldReturnFalse() {
        val checmanager = CredentialsManager()
        assertEquals(false, checmanager.isPasswordEmpty("securePasswordABC123"))
    }

    @Test
    fun whenPasswordIsNotEmpty_shouldReturnTrueForFilled() {
        val checmanager = CredentialsManager()
        assertEquals(true, checmanager.isPasswordFilled("myPasswordABC123"))
    }

    @Test
    fun whenPasswordIsEmpty_shouldReturnFalseForFilled() {
        val checmanager = CredentialsManager()
        assertEquals(false, checmanager.isPasswordFilled(""))
    }
}
