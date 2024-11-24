class CredentialsManager {

    private val useremail =
        ("[a-zA-Z0-9\\+\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+").toRegex()

    fun isEmailValid(email: String): Boolean {
        return email.matches(useremail)
    }

    fun isEmailEmpty(email: String): Boolean {
        return email.isEmpty()
    }

    fun isPasswordEmpty(password: String): Boolean {
        return password.isEmpty()
    }

    fun isPasswordFilled(password: String): Boolean {
        return password.isNotEmpty()
    }
}
