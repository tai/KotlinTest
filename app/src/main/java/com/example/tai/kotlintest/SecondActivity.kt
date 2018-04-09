package com.example.tai.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

import kotlinx.android.synthetic.main.activity_second.textview_label
import kotlinx.android.synthetic.main.activity_second.textview_random
import java.util.logging.Logger


class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
        val log = Logger.getLogger(javaClass.enclosingClass.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        log.info("entered")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // update view using value in intent
        showRandomNumber()
    }

    fun showRandomNumber() {
        log.info("entered")
        // Get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

        // Generate the random number
        val random = Random()
        var randomInt = 0
        // Add one because the bound is exclusive
        if (count > 0) {
            // Add one because the bound is exclusive
            randomInt = random.nextInt(count + 1)
        }

        // Display the random number.
        textview_random.text = Integer.toString(randomInt)

        // Substitute the max value into the string resource
        // for the heading, and update the heading
        textview_label.text = getString(R.string.random_heading, count)
    }
}
