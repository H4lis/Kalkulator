    package com.example.loginkalkulator

    import android.content.Intent
    import android.os.Bundle
    import android.text.method.PasswordTransformationMethod
    import android.widget.Button
    import android.widget.EditText
    import android.widget.ImageButton
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.widget.addTextChangedListener

    class SingInActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sing_in)

            // Navigate to RegisterActivity when "Register" TextView is clicked
            val tvRegister = findViewById<TextView>(R.id.tv_register)
            tvRegister.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

            // Navigate to KalkulatorActivity when "Sign In" Button is clicked
            val btnSignIn = findViewById<Button>(R.id.btn_login)
            btnSignIn.setOnClickListener {
                val intent = Intent(this, KalkulatorActivity::class.java)
                startActivity(intent)
            }

            // Find views related to password and eye icon
            val etPassword = findViewById<EditText>(R.id.et_password)
            val btnTogglePassword = findViewById<ImageButton>(R.id.btnTogglePassword)

            // Set a listener to toggle password visibility
            btnTogglePassword.setOnClickListener {
                // Toggle password visibility
                etPassword.transformationMethod =
                    if (etPassword.transformationMethod == null)
                        PasswordTransformationMethod.getInstance()
                    else null

                // Move the cursor to the end of the text to keep the visual cursor position


                val newIcon = if (etPassword.transformationMethod == null) {
                    R.drawable.ic_eye_closed // Ganti dengan ikon mata tertutup
                } else {
                    R.drawable.ic_eye // Ganti dengan ikon mata terbuka
                }
                etPassword.setSelection(etPassword.text.length)


            }

            // Add a text changed listener to clear the checkbox state when the password changes
            etPassword.addTextChangedListener {
                btnTogglePassword.isPressed = false
            }
        }
    }