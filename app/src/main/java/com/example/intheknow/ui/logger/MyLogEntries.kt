package com.example.intheknow.ui.logger

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intheknow.App
import com.example.intheknow.R
import com.example.intheknow.data.Event
import com.example.intheknow.data.EventListModifier
import com.example.intheknow.data.UserResolver
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_my_log_entries.*
import java.util.*
import kotlin.collections.ArrayList


class MyLogEntries : Fragment(), EventAdapter.OnItemDeleteListener, EventAdapter.OnItemEditListener {

    /*
    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            view?.let { Navigation.findNavController(it).navigate(R.id.action_myLogEntries_to_startDestination) }
        }
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Creating Fragment", "RESETTING EVENT LIST")
        //EventListModifier.eventList = generateDummyLog(0)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycle_view_events.layoutManager = LinearLayoutManager(context)
        recycle_view_events.adapter = EventListModifier.adapter
        recycle_view_events.setHasFixedSize(true)
        if (EventListModifier.eventList.isEmpty()) {
            //val setupList : ArrayList<Event> = App.getDB().queryEventsByUserID(UserResolver.id)
            //Log.d("Setup List Size: ", setupList.size.toString())
            //EventListModifier.setupEventList(setupList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_my_log_entries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newEventButton : FloatingActionButton = view.findViewById(R.id.fab_add_event)
        newEventButton.setOnClickListener {
            findNavController().navigate(R.id.action_myLogEntries_to_myLogger)
        }
        val homeBtn : Button = view.findViewById(R.id.home_btn)
        homeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myLogEntries_to_startDestination)
        }
        //requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    /*
    override fun onStart() {
        super.onStart()
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onStop() {
        callback.remove()
        super.onStop()
    }
    */

    private fun generateDummyLog(size : Int): ArrayList<Event> {

        val list = ArrayList<Event>()

        var year = 20
        var month = 0
        var day = 7

        val eventArray: Array<String> = arrayOf(Event.VAGINAL, Event.ANAL, Event.ORAL, Event.NON_PENETRATIVE)

        val protectionArray : Array<String> = arrayOf(Event.WITHDRAWAL, Event.CONDOM, Event.FERTILITY_AWARENESS,
            Event.MINI_PILL, Event.COMBO_PILL, Event.IUD, Event.RING, Event.PATCH)

        val feelingArray: Array<String> = arrayOf(Event.WITHDRAWAL, Event.CONDOM, Event.FERTILITY_AWARENESS,
            Event.MINI_PILL, Event.COMBO_PILL, Event.IUD, Event.RING, Event.PATCH)

        val symptomsArray: Array<String> = arrayOf(Event.NAUSEA, Event.NIGHT_SWEATS, Event.MOUTH_SORES,
            Event.VOMITING, Event.MUSCLE_ACHES, Event.JOINT_PAIN, Event.INFECTION, Event.SORE_THROAT)

        val commentsList : ArrayList<String> = arrayListOf<String>("Sticking to my goals", "Feeling all right",
                "Haven't been sticking to goals", "Feel healthy", "Went to sleep just fine", "Had trouble falling asleep")

        for (i in 0 until size) {
            //populate random date
            val date : GregorianCalendar = GregorianCalendar(year + 2000, month, day)
            month = month + (0..5).random()
            if (month >= 12) {
                year += 1
                month = month % 12
            }
            day = (0..28).random()

            //populate random event
            val sexCategories = ArrayList<String>()
            val occurrence = (0..1).random()
            if (occurrence == 1) {
                for (j in 0..2) {
                    val eventFlag = (0..1).random()
                    if (eventFlag == 1) {
                        sexCategories.add(eventArray[j])
                    }
                }
            } else {
                sexCategories.add(eventArray[3])
            }

            //populate random protection
            val protection = ArrayList<String>()
            for (j in 0..7) {
                val protectionFlag = (0..1).random()
                if (protectionFlag == 1) {
                    protection.add(protectionArray[j])
                }
            }

            //populate random feeling
            val feelings = ArrayList<String>()
            for (j in 0..7) {
                val feelingFlag = (0..1).random()
                if (feelingFlag == 1) {
                    feelings.add(feelingArray[j])
                }
            }
            //populate random symptom
            val symptoms = ArrayList<String>()
            for (j in 0..7) {
                val symptomFlag = (0..1).random()
                if (symptomFlag == 1) {
                    symptoms.add(symptomsArray[j])
                }
            }
            //populate random text
            val randomText = commentsList.get((0..5).random())

            val logEntry = Event(date, sexCategories, protection, feelings, symptoms, randomText)
            list += logEntry
        }
        return list
    }

    override fun onItemDelete(position: Int) {
        EventListModifier.deleteEvent(position)
    }

    override fun onItemEdit(position: Int, itemView: View) {
        EventListModifier.itemSelector = position
        itemView.findNavController().navigate(R.id.action_myLogEntries_to_myLoggerEdit)
    }
}