package com.example.intheknow.ui.logger

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ToggleButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.Event
import com.example.intheknow.data.EventListModifier
import java.util.*
import kotlin.collections.HashSet

/**
 * A simple [Fragment] subclass.
 * Use the [MyLogger.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyLogger : Fragment() {
    private lateinit var viewModel: MyLoggerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i("MyLoggerFragment", "Called ViewModelProvider.get")

        return inflater.inflate(R.layout.fragment_my_logger, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(MyLoggerViewModel::class.java)
        val history_btn : Button = view.findViewById(R.id.skip_to_log_btn)
        val submit_btn : Button = view.findViewById(R.id.new_log_submit_btn)

        //toggle buttons from logger
        val no_condom_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.no_condom_btn)
        val condom_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.condom_btn)
        val oral_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.oral_btn)
        val by_myself_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.by_myself_btn)
        val great_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.great_btn)
        val depressed_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.depressed_btn)
        val nervous_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.nervous_btn)
        val anxious_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.anxious_btn)
        val tired_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.tired_btn)
        val motivated_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.motivated_btn)
        val angry_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.angry_btn)
        val eh_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.eh_btn)
        val nausea_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.nausea_btn)
        val night_sweats_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.nightsweats_btn)
        val mouth_sores_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.mouthsores_btn)
        val vomiting_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.vomiting_btn)
        val muscle_aches_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.muscle_aches_btn)
        val joint_pain_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.joint_pain_btn)
        val infection_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.infection_btn)
        val sore_throat_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.sore_throat)

        //parallel arrays
        val feelings_button_arr : Array<ToggleButton> = arrayOf(great_btn, depressed_btn,
            nervous_btn, anxious_btn, tired_btn, motivated_btn, angry_btn, eh_btn)
        val feelings_ids : Array<Int> = arrayOf(R.id.great_btn, R.id.depressed_btn, R.id.nervous_btn,
                R.id.anxious_btn, R.id.tired_btn, R.id.motivated_btn, R.id.angry_btn, R.id.eh_btn)

        val symptoms_button_arr : Array<ToggleButton> = arrayOf(nausea_btn, night_sweats_btn, mouth_sores_btn,
            vomiting_btn, muscle_aches_btn, joint_pain_btn, infection_btn, sore_throat_btn)

        val symptoms_ids : Array<Int> = arrayOf(R.id.nausea_btn, R.id.nightsweats_btn, R.id.mouthsores_btn,
                R.id.vomiting_btn, R.id.muscle_aches_btn, R.id.joint_pain_btn, R.id.infection_btn, R.id.sore_throat)

        history_btn.setOnClickListener {
            findNavController().navigate(R.id.action_myLogger_to_myLogEntries)
        }
        submit_btn.setOnClickListener {
            //set data in view model
            val submit_sex : HashSet<Int> = HashSet<Int>()
            if (no_condom_btn.isChecked) submit_sex.add(R.id.no_condom_btn)
            if (condom_btn.isChecked) submit_sex.add(R.id.condom_btn)
            if (oral_btn.isChecked) submit_sex.add(R.id.oral_btn)
            if (by_myself_btn.isChecked) submit_sex.add(R.id.by_myself_btn)

            val submit_feelings : HashSet<Int> = HashSet<Int>()
            for ((index, button) in feelings_button_arr.withIndex()) {
                if (button.isChecked) submit_feelings.add(feelings_ids[index])
            }
            val submit_symptoms : HashSet<Int> = HashSet<Int>()
            for ((index, button) in symptoms_button_arr.withIndex()) {
                if (button.isChecked) submit_symptoms.add(symptoms_ids[index])
            }
            val submit_date : GregorianCalendar = GregorianCalendar()
            val submit_log : EditText = view.findViewById(R.id.new_log_edit_text)
            val submit_log_text : String = submit_log.text.toString()

            Log.d("ONSUBMIT_LOG", submit_log_text)
            viewModel.setDate(submit_date)
            viewModel.setLog(submit_log_text)
            viewModel.setFeelings(submit_feelings)
            viewModel.setSymptoms(submit_symptoms)
            viewModel.setSexCategories(submit_sex)
            viewModel.setID(Random().nextFloat())

            Log.d("ONSUBMIT_LOG_2", viewModel.model_log.value!!)
            Log.d("SIZE", " " + EventListModifier.eventList.size)
            EventListModifier.addEvent(Event(submit_date, submit_sex, submit_feelings, submit_symptoms, submit_log_text))
            Log.d("SIZE", " " + EventListModifier.eventList.size)
            Log.d("TEST", "" + EventListModifier.eventList[0].log)
            Log.d("TEST2", "" + EventListModifier.eventList[0].sexCategories.sorted()[0])
            findNavController().navigate(R.id.action_myLogger_to_myLogEntries)
        }

        //val oral_btn : ToggleButton = view.findViewById(R.id.oral_btn)
        //oral_btn.setChecked(true)
    }

}