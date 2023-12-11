package com.example.contact_project

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter(private val contactItemLayout: Int,
                         private val deleteClickListener: OnDeleteClickListener)
    : RecyclerView.Adapter<ContactListAdapter.ViewHolder>(){

    private var contactData: List<Contact>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val nameText = holder.nameText
        val phoneText = holder.phoneText
        var id = holder.id
        contactData.let {
            nameText.text = it!![listPosition].contactName
            phoneText.text = it!![listPosition].contactPhone
            id = it!![listPosition].contactId
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (contactData == null) 0 else contactData!!.size
    }

    interface OnDeleteClickListener {
        fun onDeleteClick(contact: Contact)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.itemName)
        val phoneText: TextView = itemView.findViewById(R.id.itemPhone)
        private val deleteImage: ImageView = itemView.findViewById(R.id.deleteImage)
        init {
            deleteImage.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val contactToDelete = contactData?.get(position)
                    contactToDelete?.let { contact ->
                        deleteClickListener.onDeleteClick(contact) // Notify the interface
                    }
                }
            }
        }

        val id: Int = 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContactList(contacts: List<Contact>) {
        contactData = contacts
        notifyDataSetChanged()
    }

}