package com.example.intheknow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_my_log_entries.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


class MyLogEntries : Fragment() {
    private lateinit var viewModel: MyLoggerViewModel

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

        /*
        viewModel = ViewModelProvider(this).get(MyLoggerViewModel::class.java)
        viewModel.randomIdentifier.observe(viewLifecycleOwner, androidx.lifecycle.Observer { new_id ->
            var new_sex : Set<Int> = HashSet<Int>()
            if (viewModel.model_sex_categories.value != null) new_sex = viewModel.model_sex_categories.value!!
            var new_feelings : Set<Int> = HashSet<Int>()
            if (viewModel.model_feelings.value != null) new_feelings = viewModel.model_feelings.value!!
            var new_symptoms : Set<Int> = HashSet<Int>()
            if (viewModel.model_symptoms.value != null) new_symptoms = viewModel.model_symptoms.value!!
            var new_log : String = ""
            if (viewModel.model_log.value != null) new_log = viewModel.model_log.value!!

            var new_date : GregorianCalendar = GregorianCalendar()
            if (viewModel.model_date.value != null) new_date = viewModel.model_date.value!!

            var new_event = Event(new_date, new_sex, new_feelings, new_symptoms, new_log)
            eventList.add(new_event)
            adapter.notifyItemInserted(eventList.size - 1)
            Log.d("myTag", "EVENT CREATED")
            Log.d("len", "str: " + viewModel.model_log.value!!)
            Log.d("size of event list", "size: " + eventList.size)
        })

         */
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
    }

    private fun generateDummyLog(size : Int): ArrayList<Event> {

        val list = ArrayList<Event>()

        var year = 20
        var month = 0
        var day = 7

        val eventArray: IntArray = intArrayOf(R.id.no_condom_btn, R.id.condom_btn, R.id.oral_btn, R.id.by_myself_btn)
        for (i in 0..3) {
            Log.d("value", eventArray[i].toString())
        }
        val feelingArray: IntArray = intArrayOf(R.id.great_btn, R.id.depressed_btn, R.id.nervous_btn,
            R.id.anxious_btn, R.id.tired_btn, R.id.motivated_btn, R.id.angry_btn, R.id.eh_btn)

        val symptomsArray: IntArray = intArrayOf(R.id.nausea_btn, R.id.nightsweats_btn, R.id.mouthsores_btn,
            R.id.vomiting_btn, R.id.muscle_aches_btn, R.id.joint_pain_btn, R.id.infection_btn, R.id.sore_throat)

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
            val sexCategories = HashSet<Int>()
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
            //populate random feeling
            val feelings = HashSet<Int>()
            for (j in 0..7) {
                val feelingFlag = (0..1).random()
                if (feelingFlag == 1) {
                    feelings.add(feelingArray[j])
                }
            }
            //populate random symptom
            val symptoms = HashSet<Int>()
            for (j in 0..7) {
                val symptomFlag = (0..1).random()
                if (symptomFlag == 1) {
                    feelings.add(symptomsArray[j])
                }
            }
            //populate random text
            val randomText = commentsList.get((0..5).random())

            val logEntry = Event(date, sexCategories, feelings, symptoms, randomText)
            list += logEntry
        }
        return list
    }
}