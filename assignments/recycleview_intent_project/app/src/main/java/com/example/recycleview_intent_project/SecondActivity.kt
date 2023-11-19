package com.example.recycleview_intent_project

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity_layout)
        val imageView: ImageView = findViewById(R.id.imageView)
        val itemTitleView: TextView = findViewById(R.id.titleText)
        val itemDescriptionView: TextView = findViewById(R.id.descriptionText)
        imageView.setImageResource(intent.getIntExtra("image", 0))
        itemTitleView.text = intent.getStringExtra("title")
        itemDescriptionView.text = intent.getStringExtra("description")
    }
}