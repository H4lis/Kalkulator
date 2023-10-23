package com.example.loginkalkulator


import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.loginkalkulator.databinding.ActivityKalkulatorBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat








class KalkulatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKalkulatorBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKalkulatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.profileImage.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }



        // Sekarang Anda dapat menggunakan binding untuk mengakses elemen UI
        binding.buttonClear.setOnClickListener {
            binding.input.text = ""
            binding.output.text = ""
        }

        binding.buttonBrecketLeft.setOnClickListener {
            addToInputText("(")
        }

        binding.buttonBrecketRight.setOnClickListener {
            addToInputText(")")
        }

        binding.button0.setOnClickListener {
            addToInputText("0")
        }

        binding.button1.setOnClickListener {
            addToInputText("1")
        }

        binding.button2.setOnClickListener {
            addToInputText("2")
        }

        binding.button3.setOnClickListener {
            addToInputText("3")
        }

        binding.button4.setOnClickListener {
            addToInputText("4")
        }

        binding.button5.setOnClickListener {
            addToInputText("5")
        }

        binding.button6.setOnClickListener {
            addToInputText("6")
        }

        binding.button7.setOnClickListener {
            addToInputText("7")
        }

        binding.button8.setOnClickListener {
            addToInputText("8")
        }

        binding.button9.setOnClickListener {
            addToInputText("9")
        }

        binding.buttonDot.setOnClickListener {
            addToInputText(".")
        }

        binding.buttonDevision.setOnClickListener {
            addToInputText("÷")
        }

        binding.buttonMultiplay.setOnClickListener {
            addToInputText("×")
        }

        binding.buttonSubtraction.setOnClickListener {
            addToInputText("-")
        }

        binding.buttonAddition.setOnClickListener {
            addToInputText("+")
        }

        binding.buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String) {
        binding.input.text = "${binding.input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = binding.input.text.toString()
        expression = expression.replace("÷", "/").replace("×", "*")
        return expression
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.output.text = "Error"
                binding.output.setTextColor(getColor(R.color.red))
            } else {
                // Show Result
                val formattedResult = DecimalFormat("0.######").format(result)
                binding.output.text = formattedResult
                binding.output.setTextColor(getColor(R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.output.text = "Error"
            binding.output.setTextColor(getColor(R.color.red))
        }
    }

    }

