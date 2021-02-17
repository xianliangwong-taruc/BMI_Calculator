package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputName = findViewById<EditText>(R.id.name_input)





        val btnEnter = findViewById<View>(R.id.buttonEnter)

        btnEnter.setOnClickListener(){
            val intent = Intent(this, CalculateBMI::class.java)
            val inputName = findViewById<EditText>(R.id.name_input).text
            intent.putExtra("inputName",inputName)
            startActivity(intent)
        }
    }
}