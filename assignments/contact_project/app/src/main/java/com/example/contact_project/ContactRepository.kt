package com.example.contact_project

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ContactRepository(application: Application) {
    val searchResults = MutableLiveData<List<Contact>>()
    var allContacts: LiveData<List<Contact>>?
    var sortedData = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }


    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun sortData(sort: String) {
        coroutineScope.launch(Dispatchers.Main) {
            sortedData.value = asyncSort(sort).await()
        }
    }
    private fun asyncSort(sort: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            if (sort == "asc")
            {
                return@async contactDao?.getContactsSortedByNameAsc()
            }
            else{
                return@async contactDao?.getContactsSortedByNameDesc()
            }

        }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }
    private fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }

}