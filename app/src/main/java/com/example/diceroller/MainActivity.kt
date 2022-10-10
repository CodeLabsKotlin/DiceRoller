package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Listener boton roll
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        //Listener boton clear
        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clear() }
    }

    /**
     * Funcion con la que lanzamos los dados
     */
    private fun rollDice(){
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    /**
     * Funcion mediante la cual se muestran valores al azar comprendidos entre 1 y 6 en los dados
     */
    private fun getRandomDiceImage() : Int{
        val randomInt = (1..6).random()

        return when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    /**
     * Funcion con la que reseteamos los dados
     */
    private fun clear(){
        diceImage.setImageResource(0)
        diceImage2.setImageResource(0)
    }
}