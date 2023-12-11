package com.example.contact_project
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var contactId: Int = 0,
    var contactName: String,
    var contactPhone: String
)