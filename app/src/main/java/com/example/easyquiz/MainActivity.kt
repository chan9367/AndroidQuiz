package com.example.easyquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questionTextView = findViewById<TextView>(R.id.textViewQuestion)
        val buttonA = findViewById<Button>(R.id.buttonA)
        val buttonB = findViewById<Button>(R.id.buttonB)
        val buttonC = findViewById<Button>(R.id.buttonC)

        val questionsArr = arrayOf<String>(
            "1) What are the two official languages for Android development? \n\n A) Kotlin and Java \n\n B) Java and Python \n\n C) Kotlin and Python",
            "2) How do you define a variable in Kotlin? \n\n A) void \n\n B) var \n\n C) function",
            "3) What is a variable used for? \n\n A) To contain data \n\n B) To insert a random value \n\n C) Don't know",
            "4) What does SDK stand for in Android SDK? \n\n A) Something Don't Know \n\n B) Software Development Kotlin \n\n C) Software Development Kit"
        )

        val rightAnswers = listOf(1, 2, 1, 3)

        var questionNum = 0

        fun updateQuestion() {
            questionNum += 1
            if (questionNum == questionsArr.size) questionNum = 0
            questionTextView.text = questionsArr[questionNum]
        }

        fun showToast(answer: Int) {
            if (answer == rightAnswers[questionNum]) {
                Toast.makeText(applicationContext, "CORRECT!", Toast.LENGTH_SHORT).show()
                updateQuestion()
            } else {
                Toast.makeText(applicationContext, "WRONG!", Toast.LENGTH_SHORT).show()
            }
        }

        buttonA.setOnClickListener { showToast(1) }
        buttonB.setOnClickListener { showToast(2) }
        buttonC.setOnClickListener { showToast(3) }
    }
}