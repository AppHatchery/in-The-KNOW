package com.example.intheknow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyLoggerViewModel : ViewModel() {
    private val logs: MutableLiveData<List<Event>> by lazy {
        MutableLiveData<List<Event>>().also {
            loadEvents()
        }
    }

    fun getEvents(): LiveData<List<Event>> {
        return logs
    }

    private fun loadEvents() {
        // Do an asynchronous operation to fetch users.
    }

    init {
        Log.i("MyLoggerViewModel", "MyLoggerViewModel created!")
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("MyLoggerViewModel", "MyLoggerViewModel destroyed!")
    }
}