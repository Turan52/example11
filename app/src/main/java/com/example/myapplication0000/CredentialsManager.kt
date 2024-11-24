class CredentialsManager {

    private val emailVal =
        ("[a-zA-Z0-9\\+\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+").toRegex()

    private val registeredAccounts = mutableMapOf<String, String>()

    fun validateEmail(email: String) {
        require(email.isNotEmpty()) { "Email cannot be empty." }
        require(email.matches(emailVal)) { "Invalid email format." }
    }

    fun validatePassword(password: String) {
        require(password.isNotEmpty()) { "Password cannot be empty." }
        require(password.length >= 6) { "Password must be at least 6 characters long." }
    }

    fun register(email: String, password: String) {
        val normalizedEmail = email.lowercase()
        require(!registeredAccounts.containsKey(normalizedEmail)) {
            "This email is already registered."
        }
        registeredAccounts[normalizedEmail] = password
    }
}
