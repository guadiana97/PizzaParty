/**
 * Author: Alberto Guadiana
 * Project: LAB1 CS 646
 * Date: 2/12/2024
 *
 * Description: Pizza Party Application that calculates total number of pizzas
 * needed based on hunger level and amount of people.
 */

package com.zybooks.pizzaparty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * This class takes care of interacting with the UI.
 * AppCompatActivity serves as the superclass inherited by MainActivity for
 * all activities and provides latest Android functionality for older versions.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    /**
     * Loading the XML layout and performing initialization
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    /**
     * Calculating for total number of pizzas by converting string to int
     */
    fun calculateClick(view: View) {
        // Get text typed into EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert text string to int
        val numAttend = numAttendStr.toInt()

        // Determine number of slices on average for reach person
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

        // Calculate and how the number of pizzas needed
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}