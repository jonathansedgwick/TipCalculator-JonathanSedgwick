package com.example.jonathan.tipcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text
import java.text.DecimalFormat

lateinit var costInput: EditText
lateinit var percentInput: Spinner
lateinit var calcButton: Button
lateinit var resultOutput: TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        costInput = findViewById(R.id.costInput)
        percentInput = findViewById(R.id.percentageInput)
        calcButton = findViewById(R.id.calcButton)
        resultOutput = findViewById(R.id.resultOutput)

        calcButton.setOnClickListener{
            if (checkData()) {
                var mealCost = costInput.text.toString().toDouble()
                var percent = 0.0
                if (percentInput.selectedItem.toString() == "5%")
                    percent = 0.05
                else if (percentInput.selectedItem.toString() == "10%")
                    percent = 0.1
                else if (percentInput.selectedItem.toString() == "15%")
                    percent = 0.15
                else if (percentInput.selectedItem.toString() == "20%")
                    percent = 0.2
                else (percentInput.selectedItem.toString() == "25%")
                    percent = 0.25
                var tip:Double = mealCost * percent
                var currency = DecimalFormat("$#,###.00")
                var formattedTip = currency.format(tip)
                var output = "The tip should be $formattedTip"
                resultOutput.text = output
            }
        }

    }

    private fun checkData(): Boolean {

        if (costInput.text.toString().isEmpty()) {
            costInput.error = "Invalid Cost Input"
            costInput.requestFocus()
            return false
        }
        else
            return true


    }

}
