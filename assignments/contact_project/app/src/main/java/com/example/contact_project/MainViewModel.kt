package com.example.contact_project

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>? = repository.allContacts
    private val searchResults: MutableLiveData<List<Contact>> = repository.searchResults
    private val sortedData: MutableLiveData<List<Contact>> = repository.sortedData

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        repository.findContact(name)
    }
    fun ascContact() {
        repository.sortData("asc")
    }
    fun descContact() {
        repository.sortData("desc")
    }

    fun deleteContact(contact: Contact) {
        repository.deleteContact(contact.id)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
    fun getSortedData(): MutableLiveData<List<Contact>> {
        return sortedData
    }

}