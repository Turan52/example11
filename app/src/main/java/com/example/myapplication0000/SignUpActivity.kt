package com.example.myapplication0000

import CredentialsManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_member)

        val nameField = findViewById<EditText>(R.id.name_field)
        val emailField = findViewById<EditText>(R.id.email_field)
        val passwordField = findViewById<EditText>(R.id.password_field)
        val submitButton = findViewById<Button>(R.id.submit_button)

        val credentialsManager = CredentialsManager()

        submitButton.setOnClickListener {
            val name = nameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            when {
                name.isEmpty() -> {
                    Toast.makeText(this, "Full Name of the Candidate is required", Toast.LENGTH_SHORT).show()
                }
                email.isEmpty() -> {
                    Toast.makeText(this, "Email is required!", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(this, "Password is required!", Toast.LENGTH_SHORT).show()
                }
                else -> try {
                    credentialsManager.validateEmail(email)
                    credentialsManager.validatePassword(password)
                    credentialsManager.register(email, password)


                    Toast.makeText(this, "Sign-up Successful!", Toast.LENGTH_LONG).show()


                    nameField.text.clear()
                    emailField.text.clear()
                    passwordField.text.clear()
                } catch (e: IllegalArgumentException) {
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

