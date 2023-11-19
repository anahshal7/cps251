package com.example.recycleview_intent_project

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
data class ItemModel(val itemTitle: String, val itemDescription: String, val itemImage: Int)
class RecycleViewAdapter  (private val context: Context, private val data: ArrayList<ItemModel>)
    : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.itemTitleView.text = item.itemTitle
        holder.itemDescriptionView.text = item.itemDescription
        holder.imageView.setImageResource(item.itemImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("title", item.itemTitle)
            intent.putExtra("description", item.itemDescription)
            intent.putExtra("image", item.itemImage)
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.itemImage)
        val itemTitleView: TextView = itemView.findViewById(R.id.itemTitle)
        val itemDescriptionView: TextView = itemView.findViewById(R.id.itemDescription)
    }
}