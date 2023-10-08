package com.example.tipcalculator
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextBillAmount = findViewById<EditText>(R.id.editTextBillAmount)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textView10PercentTip = findViewById<TextView>(R.id.textView10PercentTip)
        val textView15PercentTip = findViewById<TextView>(R.id.textView15PercentTip)
        val textView20PercentTip = findViewById<TextView>(R.id.textView20PercentTip)

        buttonCalculate.setOnClickListener {
            // Get the bill amount entered by the user
            val billAmountStr = editTextBillAmount.text.toString()

            if (billAmountStr.isNotEmpty()) {
                val billAmount = billAmountStr.toDouble()

                // Calculate tips for 10%, 15%, and 20%
                val tip10Percent = billAmount * 0.10
                val tip15Percent = billAmount * 0.15
                val tip20Percent = billAmount * 0.20

                // Display the tips in TextViews
                textView10PercentTip.text = "10% Tip: $$tip10Percent"
                textView15PercentTip.text = "15% Tip: $$tip15Percent"
                textView20PercentTip.text = "20% Tip: $$tip20Percent"
            } else {
                // Handle the case where the user didn't enter a valid bill amount
                textView10PercentTip.text = "10% Tip: $0.00"
                textView15PercentTip.text = "15% Tip: $0.00"
                textView20PercentTip.text = "20% Tip: $0.00"
            }
        }
    }
}


