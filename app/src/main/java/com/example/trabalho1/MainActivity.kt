package com.example.trabalho1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Resources
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.loginButton)
        val clearBtn = findViewById<Button>(R.id.clearButton)

        // Validation of login functionality
        loginBtn.setOnClickListener {
            if(email.text.isNotEmpty() && password.text.isNotEmpty()) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email.text).matches()) {
                    Toast.makeText(this@MainActivity, "Requesting Login...", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Invalid Email", Toast.LENGTH_SHORT).show()
                }
            } else if(email.text.isEmpty() && password.text.isNotEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            } else if(email.text.isNotEmpty() && password.text.isEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter a password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Please enter a valid email and password", Toast.LENGTH_SHORT).show()
            }
        }

        // Validation of clear form functionality (to save up performance)
        clearBtn.setOnClickListener {
            if(email.text.isNotEmpty() || password.text.isNotEmpty()) {
                email.text.clear()
                password.text.clear()
            } else {
                Toast.makeText(this@MainActivity, "Nothing to clear", Toast.LENGTH_SHORT).show()
            }
        }
    }
}