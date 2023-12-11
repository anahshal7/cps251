package com.example.contact_project

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactRoomDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: ContactRoomDatabase? = null
        internal fun getDatabase(context: Context): ContactRoomDatabase? {
            if (INSTANCE == null) {
                try {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactRoomDatabase::class.java,
                        "contacts"
                    ).build()
                } catch (e: Exception) {
                    // Log or handle the exception
                    Log.e("DatabaseError", "Error creating database: ${e.message}")
                    throw e
                }
            }
            return INSTANCE
        }
    }
}