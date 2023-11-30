package com.example.coroutine_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Random


class MainActivity : AppCompatActivity() {
    class DataViewModel : ViewModel() {
        private var data: ArrayList<ItemModel> = ArrayList()
        fun insertData(item: ItemModel) {
            data.add(item)
        }

        fun getData(): ArrayList<ItemModel> {
            return data
        }
    }
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[DataViewModel::class.java]
        adapter = RecyclerViewAdapter(viewModel.getData())
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            simulateSleepAndAddItem(nameInput.text.toString())
            nameInput.text = null
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun simulateSleepAndAddItem(name: String) {
        val randomSleepTime = Random().nextInt(10) + 1
        GlobalScope.launch(Dispatchers.Main) {
            val sleptFor = simulateSleep(randomSleepTime)
            addItemToList(name, sleptFor)
        }
    }

    private suspend fun simulateSleep(seconds: Int): Int {
        return withContext(Dispatchers.IO) {
            Thread.sleep(seconds * 1000L)
            seconds
        }
    }

    private fun addItemToList(name: String, sleptFor: Int) {
        viewModel.insertData(ItemModel(name, sleptFor))
        adapter.notifyItemInserted(viewModel.getData().size - 1)

    }
}