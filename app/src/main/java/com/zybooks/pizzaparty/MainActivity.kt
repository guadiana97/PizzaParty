package com.zybooks.pizzaparty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
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

    /**
     * Loading the XML layout and performing initialization
     *
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
    }

    /**
     * Calculating for total number of pizzas by converting string to int
     */
    fun calculateClick(view: View) {
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toInt()
        val slicesPerPerson = 4
        val totalPizzas = ceil(numAttend * slicesPerPerson /
                SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}