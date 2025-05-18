package com.example.s04_flores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEmpezar = findViewById<Button>(R.id.btnEmpezar)
        btnEmpezar.setOnClickListener {
            startActivity(Intent(this, QuestionView::class.java))
        }
    }
}
