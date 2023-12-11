package com.example.contact_project

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE LOWER(name) LIKE '%' || LOWER(:name) || '%'")
    fun findContact(name: String): List<Contact>

    @Query("SELECT * FROM contacts ORDER BY name")
    fun getContactsSortedByNameAsc(): List<Contact>

    @Query("SELECT * FROM contacts ORDER BY name DESC")
    fun getContactsSortedByNameDesc(): List<Contact>

    @Query("DELETE FROM contacts WHERE id = :id")
    fun deleteContact(id: Int)

}