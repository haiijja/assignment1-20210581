package com.example.hw1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var uniSpinner: Spinner
    private lateinit var uniEditText: EditText
    private lateinit var uniTextView: TextView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.applyBtn)
        button.setOnClickListener { view -> }
        uniSpinner = findViewById(R.id.uniSpinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.unis_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            uniSpinner.adapter = adapter
        }
        button.setOnClickListener {
            val options = uniEditText.text.toString()
            val optionList = options.split(",").map { it.trim() }.filter { it.isNotEmpty() }
            if (optionList.isNotEmpty()) {
                val decisionResult = decide(optionList)
                uniTextView.text = "Decision Result: $decisionResult"
            } else {
                uniTextView.text = "Please enter at least one option."
            }

        }
    }


    private fun decide(options: List<String>): String {
        val randomIndex = (0 until options.size).random()
        return options[randomIndex]
    }
}
