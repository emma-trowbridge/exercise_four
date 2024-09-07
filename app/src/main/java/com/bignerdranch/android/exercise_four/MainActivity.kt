package com.bignerdranch.android.exercise_four


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bignerdranch.android.exercise_four.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter = Counter() //creates instance for Counter class


    class Counter {
        private var count: Int = 0

        fun addCount() {
            count++
        }

        fun getCount(): Int {
            return count
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing view binding
        binding = ActivityMainBinding.inflate(layoutInflater) // initializes view binding
        setContentView(binding.root) //sets content view

        //sets up button clicker listener
        binding.button.setOnClickListener {
            counter.addCount() //increment the count
            binding.textView.text = counter.getCount().toString() //updates textview with new count
        }
    } //each time button is clicked, the counter is increased and the textview is updated to reflect count
}