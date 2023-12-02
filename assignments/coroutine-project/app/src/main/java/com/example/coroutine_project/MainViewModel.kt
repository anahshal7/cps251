package com.example.coroutine_project

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var data: ArrayList<ItemModel> = ArrayList()
    fun insertData(item: ItemModel) {
        data.add(item)
    }

    fun getData(): ArrayList<ItemModel> {
        return data
    }
}