package com.example.contact_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contact_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ContactListAdapter.OnDeleteClickListener {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onDeleteClick(contact: Contact) {
        viewModel.deleteContact(contact)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.editTextName.setText("")
        binding.editTextPhoneNumber.setText("")
    }

    private fun listenerSetup() {
        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val phoneNumber = binding.editTextPhoneNumber.text.toString()
            if (name == ""){
                Toast.makeText(this, "Name must not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (phoneNumber == ""){
                Toast.makeText(this, "Phone must not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val contact = Contact(contactName = name, contactPhone = phoneNumber)
            viewModel.insertContact(contact)
            clearFields()
        }

        binding.buttonFind.setOnClickListener {
            val nameSearch = binding.editTextName.text.toString()
            if (nameSearch == ""){
                Toast.makeText(this, "Name must not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.findContact(nameSearch)
            clearFields()
        }

        binding.buttonAsc.setOnClickListener {
            viewModel.ascContact()
        }

        binding.buttonDesc.setOnClickListener {
            viewModel.descContact()
        }

    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }

        viewModel.getSearchResults()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }
        viewModel.getSortedData()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }


    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout, this)
        binding.recyclerViewContacts.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewContacts.adapter = adapter
    }


}