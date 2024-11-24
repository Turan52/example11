import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows

class CredentialsManagerTest {

    @Test
    fun givenAlreadyRegisteredEmail_shouldThrowError() {
        val manager = CredentialsManager()
        manager.register("abcdef@example.com", "password123ABC.")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            manager.register("abcdef@example.com", "password123ABC.")
        }
        assertEquals("Email is already registered.", exception.message)
    }
    @Test
    fun givenNewEmail_shouldRegisterSuccessfully() {
        val manager = CredentialsManager()
        manager.register("abcdef@example.com", "password123ABC.")
    }

    @Test
    fun givenInvalidEmailForRegistration_shouldThrowError() {
        val manager = CredentialsManager()

        val exception = assertThrows(IllegalArgumentException::class.java) {
            manager.register("invalid-email", "password123")
        }
        assertEquals("Invalid email format.", exception.message)
    }

    @Test
    fun givenEmptyPasswordForRegistration_shouldThrowError() {
        val manager = CredentialsManager()

        val exception = assertThrows(IllegalArgumentException::class.java) {
            manager.register("user@example.com", "")
        }
        assertEquals("Password cannot be empty.", exception.message)
    }
}

@Test
fun givenShortPassword_shouldThrowError() {
    val manager = CredentialsManager()
    val exception = assertThrows(IllegalArgumentException::class.java) {
        manager.validatePassword("12345")
    }
    assertEquals("Password must be at least 8 characters long.", exception.message)
}

@Test
fun givenValidPassword_shouldNotThrowError() {
    val manager = CredentialsManager()
    manager.validatePassword("securePassword123ABC")
}
}