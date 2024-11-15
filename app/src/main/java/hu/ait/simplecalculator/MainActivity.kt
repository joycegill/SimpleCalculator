package hu.ait.simplecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

public class MainActivity : AppCompatActivity() {

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val number1: EditText = findViewById(R.id.number1)
        val number2: EditText = findViewById(R.id.number2)
        val btn_add: Button = findViewById(R.id.btn_add)
        val btn_sub: Button = findViewById(R.id.btn_sub)
        val answer: TextView = findViewById(R.id.answer)

        // Add button
        btn_add.setOnClickListener {
            // Convert input to numbers and add them
            val num1 = number1.text.toString().toIntOrNull()
            val num2 = number2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 + num2
                answer.text = getString(R.string.result, result)
            } else {
                answer.text= getString(R.string.error_message)
            }
        }


        // Set click listener for the Subtract button
        btn_sub.setOnClickListener {
            // Convert input to numbers and subtract them
            val num1 = number1.text.toString().toIntOrNull()
            val num2 = number2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 - num2
                answer.text = getString(R.string.sub_answer, result)
            } else {
                answer.text = getString(R.string.text_sub)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}