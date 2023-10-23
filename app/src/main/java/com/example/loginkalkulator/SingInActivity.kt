package com.example.loginkalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SingInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        val tvRegister = findViewById<TextView>(R.id.tv_register)
        tvRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            val intent = Intent(this, KalkulatorActivity::class.java)
            startActivity(intent)
        }



    }
}