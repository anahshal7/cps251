package com.example.recycleview_intent_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class NumberViewModel : ViewModel() {
    var randomNumbers: Array<Int>? = null
}

class MainActivity : AppCompatActivity() {
    private val viewModel: NumberViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecycleViewAdapter
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
        val data : ArrayList<ItemModel> = ArrayList()
        viewModel.randomNumbers?.forEachIndexed {index, value ->
            data.add(ItemModel(titles[value], descriptions[value], imageResources[value]))
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecycleViewAdapter(this, data)
        recyclerView.adapter = adapter
    }

    private fun generateRandomNumbers(size: Int): Array<Int> {
        return Array(size) { Random.nextInt(1, 8) }
    }

}