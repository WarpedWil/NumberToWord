package com.example.numbertoword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var y = ""
    var number = 0

    fun intToString(view: View){
        val editText = findViewById<EditText>(R.id.userInput) as EditText

        val userOutPut = findViewById<TextView>(R.id.outPut)
        number = editText.text.toString().toInt()

        doMath(number)
        //editText.visibility = View.GONE
        userOutPut.visibility = View.VISIBLE
        userOutPut.text = "$y"
        y = ""
    }

    private fun doMath(x: Int) {
        if(x in 1..1000) {
            if (x in 1..19) {
                if (x in 10..19) {
                    y + getTen(x)
                } else y + digits(x % 10)
            }

            if (x in 20..99) {
                y + getTens((x % 100) / 10 * 10)
                y + digits(x % 10)
            }
            if (x in 100..999) {
                y + digits((x % 1000) / 100)
                y += " Hundred "
                if ((x % 100) / 10 >= 2) {
                    y + getTens((x % 100) / 10 * 10)
                    y + digits(x % 10)
                }else y + getTen(x % 100)
                if ((x % 100) / 10 <= 1) {
                    y + digits(x%100)
                }
            }
        }
        else{
            y+= "Out of scope"
        }

        }

    fun digits(x: Int) {
        when(x) {
            1 -> y += "One"
            2 -> y += "Two"
            3 -> y += "Three"
            4 -> y += "Four"
            5 -> y += "Five"
            6 -> y += "Six"
            7 -> y += "Seven"
            8 -> y += "Eight"
            9 -> y += "Nine"
        }
    }

    fun getTen(x: Int) {
        when (x) {
            10 -> y += "Ten "
            11 -> y += "Eleven "
            12 -> y += "Twelve "
            13 -> y += "Thirteen "
            14 -> y += "Fourteen "
            15 -> y += "Fifteen "
            16 -> y += "Sixteen "
            17 -> y += "Seventeen "
            18 -> y += "Eighteen "
            19 -> y += "Nineteen "
        }
    }

    fun getTens(x:Int) {
        when (x) {
            10 -> y + getTen(x)
            20 -> y += " Twenty "
            30 -> y += " Thirty "
            40 -> y += " Forty "
            50 -> y += " Fifty "
            60 -> y += " Sixty "
            70 -> y += " Seventy "
            80 -> y += " Eighty "
            90 -> y += " Ninety "
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userButton = findViewById<Button>(R.id.convertBtn).setOnClickListener{
            intToString(it)
        }
    }
}