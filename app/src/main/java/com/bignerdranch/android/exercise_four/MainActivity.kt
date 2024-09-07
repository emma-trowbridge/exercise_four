package com.bignerdranch.android.exercise_four

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bignerdranch.android.exercise_four.databinding.ActivityMainBinding //imported binding from gradle
//ActivityMainBinding is automatically imported since binding is enabled = true in the gradle


class MainActivity : AppCompatActivity() { //base class for activities below
    private lateinit var binding: ActivityMainBinding //lateinit = binding will be initialized after activity is created
    private var counter = Counter() //creates instance for Counter class


    class Counter { // this class creates the counting (class = blueprints for object)
        private var count: Int = 0 //counter starts at 0

        fun addCount() { //fun = function
            count++ //adds one number to the next
        }

        fun getCount(): Int {
            return count //returns current value of the count
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing view binding
        binding = ActivityMainBinding.inflate(layoutInflater) // initializes view binding
        setContentView(binding.root) //sets content view

        //sets up button clicker listener
        binding.button.setOnClickListener {//when button is clicked, code inside with execute
            counter.addCount() //increment the count
            binding.textView.text = counter.getCount().toString() //updates textview with new count, toString() converts interger to string
        }
    } //each time button is clicked, the counter is increased and the textview is updated to reflect count
}