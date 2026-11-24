package com.baism.cw2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.passwordInput)
        val result = findViewById<TextView>(R.id.resultText)
        findViewById<Button>(R.id.checkButton).setOnClickListener {
            result.text = PasswordValidator.strength(input.text.toString()).name
        }
    }
}
