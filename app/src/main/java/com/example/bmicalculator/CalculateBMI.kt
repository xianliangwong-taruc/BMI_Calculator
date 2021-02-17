package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculateBMI : AppCompatActivity() {

    var bmiIndex:Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_b_m_i)

        val personaName = intent?.getStringExtra("inputName")

        val tv = findViewById<TextView>(R.id.getNameID)
        tv.setText(personaName)

        if (savedInstanceState != null) {
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            if (bmiIndex != 0.0) {
                val textView = findViewById<TextView>(R.id.statusLabel)
                textView.setText(getStatus())
            }
        }

        val calculateButton = findViewById<View>(R.id.bmiCal)

        calculateButton.setOnClickListener{
            val weight = findViewById<TextView>(R.id.weightInput).text.toString()
            val height = findViewById<TextView>(R.id.heightLabel).text.toString()

            val status = findViewById<TextView>(R.id.statusLabel)

            bmiIndex = weight.toDouble()/height.toDouble()*height.toDouble()

            status.setText(getStatus())


        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiIndex)
    }

    fun getStatus():String{

       if(bmiIndex<18.5)
           return "UnderWeight"
        else if(bmiIndex<24.9)
           return "Normal weight"
        else if(bmiIndex<29.9)
           return "overweight"
        else if(bmiIndex<34.9)
           return "Obesity class I"
       else if(bmiIndex <= 39.9)
           return "Obesity Class II"
       else
           return "Obesity Class III"




    }

}