package com.example.intheknow.ui.logger

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.HashSet

class MyLoggerViewModel : ViewModel() {
    val randomIdentifier = MutableLiveData<Float>()
    val model_date = MutableLiveData<GregorianCalendar>()
    val model_sex_categories = MutableLiveData<Set<Int>>()
    val model_feelings = MutableLiveData<Set<Int>>()
    val model_symptoms = MutableLiveData<Set<Int>>()
    val model_log = MutableLiveData<String>()

    fun setDate(date:GregorianCalendar) {
        model_date.value = date
    }
    fun setSexCategories(sex_categories:Set<Int>) {
        model_sex_categories.value = sex_categories
    }

    fun setFeelings(feelings:Set<Int>) {
        model_feelings.value = feelings
    }

    fun setSymptoms(symptoms:Set<Int>) {
        model_symptoms.value = symptoms
    }

    fun setLog(log:String) {
        model_log.value = log
    }

    fun setID(id:Float) {
        randomIdentifier.value = id
    }

    init {
        Log.d("Initializing", "INIT")
        var strval : String = " dfsadfds "
        if (model_log.value != null) strval = model_log.value!!
        Log.d("InitLOGVAR", strval)
    }
    override fun onCleared() {
        super.onCleared()
        Log.d("Clearing", "CLEARED")
        /*model_sex_categories.value = HashSet<Int>()
        model_feelings.value = HashSet<Int>()
        model_symptoms.value = HashSet<Int>()
        model_log.value = "Ougadouga"
        model_date.value = GregorianCalendar()*/
    }
}