package com.example.addnamesaveii

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NameViewModel : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // View Binding object

    class ActivityMainBinding {
        val root: Any = TODO()

        companion object {
            fun inflate(): ActivityMainBinding {
                TODO("Not yet implemented")
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate()
        binding.root
        setContentView()

        // The rest of your code goes here
    }

    private fun setContentView() {
        TODO("Not yet implemented")
    }
}

class MainActivity : AppCompatActivity()