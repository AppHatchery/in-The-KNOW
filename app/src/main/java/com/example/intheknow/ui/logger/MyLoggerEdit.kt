package com.example.intheknow.ui.logger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ToggleButton
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.Event
import com.example.intheknow.data.EventListModifier
import java.util.*
import kotlin.collections.HashSet


/**
 * A simple [Fragment] subclass.
 * Use the [MyLoggerEdit.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyLoggerEdit : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_logger_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val history_btn : Button = view.findViewById(R.id.skip_to_log_btn_edit)
        val submit_btn : Button = view.findViewById(R.id.edit_submit_btn)

        //toggle buttons from logger
        val no_condom_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.no_condom_btn_edit)
        val condom_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.condom_btn_edit)
        val oral_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.oral_btn_edit)
        val by_myself_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.by_myself_btn_edit)
        val great_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.great_btn_edit)
        val depressed_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.depressed_btn_edit)
        val nervous_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.nervous_btn_edit)
        val anxious_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.anxious_btn_edit)
        val tired_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.tired_btn_edit)
        val motivated_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.motivated_btn_edit)
        val angry_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.angry_btn_edit)
        val eh_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.eh_btn_edit)
        val nausea_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.nausea_btn_edit)
        val night_sweats_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.nightsweats_btn_edit)
        val mouth_sores_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.mouthsores_btn_edit)
        val vomiting_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.vomiting_btn_edit)
        val muscle_aches_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.muscle_aches_btn_edit)
        val joint_pain_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.joint_pain_btn_edit)
        val infection_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.infection_btn_edit)
        val sore_throat_btn : ToggleButton = view.findViewById<ToggleButton>(R.id.sore_throat_edit)

        //parallel arrays
        val feelings_button_arr : Array<ToggleButton> = arrayOf(great_btn, depressed_btn,
            nervous_btn, anxious_btn, tired_btn, motivated_btn, angry_btn, eh_btn)
        val feelings_ids : Array<Int> = arrayOf(R.id.great_btn, R.id.depressed_btn, R.id.nervous_btn,
                R.id.anxious_btn, R.id.tired_btn, R.id.motivated_btn, R.id.angry_btn, R.id.eh_btn)

        val symptoms_button_arr : Array<ToggleButton> = arrayOf(nausea_btn, night_sweats_btn, mouth_sores_btn,
            vomiting_btn, muscle_aches_btn, joint_pain_btn, infection_btn, sore_throat_btn)

        val symptoms_ids : Array<Int> = arrayOf(R.id.nausea_btn, R.id.nightsweats_btn, R.id.mouthsores_btn,
                R.id.vomiting_btn, R.id.muscle_aches_btn, R.id.joint_pain_btn, R.id.infection_btn, R.id.sore_throat)

        //fill in current
        val currentEvent : Event = EventListModifier.eventList[EventListModifier.itemSelector]
        val currentCategories : HashSet<Int> = currentEvent.sexCategories as HashSet<Int>
        val currentFeelings : HashSet<Int> = currentEvent.feelings as HashSet<Int>
        val currentSymptoms : HashSet<Int> = currentEvent.symptoms as HashSet<Int>
        val currentLog : String = currentEvent.log

        for (id in currentCategories) {
            if (id == R.id.condom_btn) condom_btn.isChecked = true
            if (id == R.id.no_condom_btn) no_condom_btn.isChecked = true
            if (id == R.id.oral_btn) oral_btn.isChecked = true
            if (id == R.id.by_myself_btn) by_myself_btn.isChecked = true
        }
        for (id in currentFeelings) {
            if (id == R.id.great_btn) great_btn.isChecked = true
            if (id == R.id.depressed_btn) depressed_btn.isChecked = true
            if (id == R.id.nervous_btn) nervous_btn.isChecked = true
            if (id == R.id.anxious_btn) anxious_btn.isChecked = true
            if (id == R.id.tired_btn) tired_btn.isChecked = true
            if (id == R.id.motivated_btn) motivated_btn.isChecked = true
            if (id == R.id.angry_btn) angry_btn.isChecked = true
            if (id == R.id.eh_btn) eh_btn.isChecked = true
        }
        for (id in currentSymptoms) {
            if (id == R.id.nausea_btn) nausea_btn.isChecked = true
            if (id == R.id.nightsweats_btn) night_sweats_btn.isChecked = true
            if (id == R.id.mouthsores_btn) mouth_sores_btn.isChecked = true
            if (id == R.id.vomiting_btn) vomiting_btn.isChecked = true
            if (id == R.id.muscle_aches_btn) muscle_aches_btn.isChecked = true
            if (id == R.id.joint_pain_btn) joint_pain_btn.isChecked = true
            if (id == R.id.infection_btn) infection_btn.isChecked = true
            if (id == R.id.sore_throat) sore_throat_btn.isChecked = true
        }
        view.findViewById<EditText>(R.id.new_log_edit_text_edit).setText(currentLog)

        history_btn.setOnClickListener {
            findNavController().navigate(R.id.action_myLoggerEdit_to_myLogEntries)
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
            val submit_log : EditText = view.findViewById(R.id.new_log_edit_text_edit)
            val submit_log_text : String = submit_log.text.toString()

            EventListModifier.editEvent(Event(submit_date, submit_sex, submit_feelings, submit_symptoms, submit_log_text))

            findNavController().navigate(R.id.action_myLoggerEdit_to_myLogEntries)
        }
    }
}