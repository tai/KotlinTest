package com.example.tai.kotlintest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.tai.kotlintest.R.id.textView

import kotlinx.android.synthetic.main.activity_main.textView

import com.example.tai.kotlintest.Logging.Companion.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        log.info("entered")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View) {
        log.info("entered")
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view: View) {
        log.info("entered")
        // old way without following:
        // import kotlinx.android.synthetic.main.activity_main.textView
        if (false) {
            // Get the text view
            val showCountTextView = findViewById(R.id.textView) as TextView

            // Get the value of the text view.
            val countString = showCountTextView.text.toString()

            // Convert value to a number and increment it
            var count: Int = Integer.parseInt(countString)
            count++

            showCountTextView.text = count.toString()
        }

        val countString = textView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        // Display the new value in the text view.
        textView.text = count.toString();
    }

    fun randomMe(view: View) {
        log.info("entered")

        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        // Get the current value of the text view.
        val countString = textView.text.toString()

        // Convert the count to an int
        val count = Integer.parseInt(countString)

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }
}
