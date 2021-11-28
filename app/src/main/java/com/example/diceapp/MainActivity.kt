package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonRoll = findViewById<TextView>(R.id.btn_roll)
        buttonRoll.setOnClickListener { rollDice() }

    }

    private fun rollDice() {

        val diceOne = Dice(6)
        val diceRollOne = diceOne.roll()
        val imageOne = when (diceRollOne) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.dice_empty
        }
        val resultOne = findViewById<ImageView>(R.id.dice_first)
        resultOne.setImageResource(imageOne)

        val diceTwo = Dice(6)
        val diceRollTwo = diceTwo.roll()
        val imageTwo = when (diceRollTwo) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.dice_empty
        }
        val resultTwo = findViewById<ImageView>(R.id.dice_second)
        resultTwo.setImageResource(imageTwo)


        val sum = diceRollOne + diceRollTwo
        val result = findViewById<TextView>(R.id.result_number)
        result.text = sum.toString()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {

        return (1..numSides).random()
    }
}


