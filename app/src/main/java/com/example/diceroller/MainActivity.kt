package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/*
* This Activity allows the user to roll a dice and view the result
* on the screen.
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Start of the application, roll the dice so an image is already there
        rollDice()
    }

    /*
    * Roll the dice and update the screen with the result.
    * */
    private fun rollDice() {
//        Create the new Dice Object with 6 sides and roll it
        val dice = Dice(6)
        val diceTwo = Dice(6)
        val diceRoll = dice.roll()
        val diceRollTwo = diceTwo.roll()

        //Find the image of the dice in the layout, and set that resource id to the value of diceImage
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        //Set the resource id to the corresponding dice image based on what the value of the dice is after being rolled
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update the diceImage resource id on the layout based on the above check
        diceImage.setImageResource(drawableResource)

        //Set the contentDescription of the image to be the same value of the dice roll
        diceImage.contentDescription = diceRoll.toString()

        val drawableResource2 = when (diceRollTwo) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource2)

        diceImage2.contentDescription = diceRollTwo.toString()

//      Update the screen with the dice roll
//        val resultTextView: TextView = findViewById(R.id.firstDice)
//        val resultTextViewTwo: TextView = findViewById(R.id.secondDice)
//        resultTextView.text = diceRoll.toString()
//        resultTextViewTwo.text = diceRollTwo.toString()
    }
}

/*
* Dice Object that has a roll function that returns a random number based on the number of sides the dice contains
* */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
