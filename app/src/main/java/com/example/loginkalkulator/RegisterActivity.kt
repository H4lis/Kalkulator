package com.example.loginkalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val textToSignIn = findViewById<TextView>(R.id.tv_sign_in)
        textToSignIn.setOnClickListener{
            val intent = Intent(this, SingInActivity::class.java)
            startActivity(intent)
        }
        val btnRegister = findViewById<Button>(R.id.btn_register)
        btnRegister.setOnClickListener {
            val intent = Intent(this, KalkulatorActivity::class.java)
            startActivity(intent)
        }




    }

}