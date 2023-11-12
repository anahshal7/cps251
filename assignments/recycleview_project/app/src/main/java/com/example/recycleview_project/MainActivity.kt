package com.example.recycleview_project


import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class NumberViewModel : ViewModel() {
    var randomNumbers: Array<Int>? = null
}

class MainActivity : AppCompatActivity() {
    private val viewModel: NumberViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageResources = intArrayOf(
            R.drawable.android_image_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
            R.drawable.android_image_4,
            R.drawable.android_image_5,
            R.drawable.android_image_6,
            R.drawable.android_image_7,
            R.drawable.android_image_8
        )
        val titles = Array(imageResources.size) { "Chapter ${it + 1}" }
        val descriptions = Array(imageResources.size) { "Item ${it + 1} details" }
        if (viewModel.randomNumbers == null) {
            viewModel.randomNumbers = generateRandomNumbers(5)
        }
        viewModel.randomNumbers?.forEachIndexed { index, value ->
            val itemId = resources.getIdentifier("item${index + 1}", "id", packageName)
            val item = findViewById<RelativeLayout>(itemId)
            item.findViewById<TextView>(R.id.itemTitle).text = titles[value]
            item.findViewById<TextView>(R.id.itemDescription).text = descriptions[value]
            item.findViewById<ImageView>(R.id.itemImage).setImageResource(imageResources[value])
        }
    }

    private fun generateRandomNumbers(size: Int): Array<Int> {
        return Array(size) { Random.nextInt(1, 9) }
    }
}