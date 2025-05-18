package com.example.s04_flores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultsView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_view)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val tvResults = findViewById<TextView>(R.id.tvResults)
        tvResults.text = "¡Tu puntaje fue $score de $total!"

    }
}