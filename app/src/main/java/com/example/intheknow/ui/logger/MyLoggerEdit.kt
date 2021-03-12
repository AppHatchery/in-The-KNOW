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
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.Event
import com.example.intheknow.data.EventListModifier
import com.example.intheknow.databinding.FragmentMyLoggerBinding
import com.example.intheknow.databinding.FragmentMyLoggerEditBinding
import java.util.*
import kotlin.collections.HashSet


/**
 * A simple [Fragment] subclass.
 * Use the [MyLoggerEdit.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyLoggerEdit : Fragment() {
    lateinit var binding: FragmentMyLoggerEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_logger_edit, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val history_btn : Button = binding.skipToLogBtnEdit
        val submit_btn : Button = binding.newLogSubmitEditBtn

        //parallel arrays
        val sex_button_arr : Array<ToggleButton> = arrayOf(binding.vaginalBtnEdit,
            binding.analBtnEdit, binding.oralBtnEdit, binding.nonPenetrativeBtnEdit)
        val sex_labels : Array<String> = arrayOf(Event.VAGINAL, Event.ANAL, Event.ORAL, Event.NON_PENETRATIVE)

        val protection_button_arr : Array<ToggleButton> = arrayOf(binding.withdrawalBtnEdit,
            binding.condomBtnEdit, binding.fertilityAwarenessBtnEdit, binding.progestinOnlyBtnEdit,
            binding.cocContraceptiveBtnEdit, binding.IUDBtnEdit, binding.vaginalRingBtnEdit, binding.patchBtnEdit)
        val protection_labels : Array<String> = arrayOf(Event.WITHDRAWAL, Event.CONDOM, Event.FERTILITY_AWARENESS,
            Event.MINI_PILL, Event.COMBO_PILL, Event.IUD, Event.RING, Event.PATCH)

        val feelings_button_arr : Array<ToggleButton> = arrayOf(binding.greatBtnEdit, binding.depressedBtnEdit,
            binding.nervousBtnEdit, binding.anxiousBtnEdit, binding.tiredBtnEdit,
            binding.motivatedBtnEdit, binding.angryBtnEdit, binding.ehBtnEdit)
        val feeling_labels : Array<String> = arrayOf(Event.GREAT, Event.DEPRESSED, Event.NERVOUS, Event.ANXIOUS,
            Event.TIRED, Event.MOTIVATED, Event.ANGRY, Event.EH)

        val symptoms_button_arr : Array<ToggleButton> = arrayOf(binding.nauseaBtnEdit, binding.nightsweatsBtnEdit,
            binding.mouthsoresBtnEdit, binding.vomitingBtnEdit, binding.muscleAchesBtnEdit, binding.jointPainBtnEdit,
            binding.infectionBtnEdit, binding.soreThroatEdit)
        val symptom_labels : Array<String> = arrayOf(Event.NAUSEA, Event.NIGHT_SWEATS, Event.MOUTH_SORES,
            Event.VOMITING, Event.MUSCLE_ACHES, Event.JOINT_PAIN, Event.INFECTION, Event.SORE_THROAT)

        //fill in current
        Log.i("Item Selector", EventListModifier.itemSelector.toString())
        Log.i("Size of Event List", EventListModifier.eventList.size.toString())
        val currentEvent : Event = EventListModifier.eventList[EventListModifier.itemSelector]

        val currentCategories : ArrayList<String> = currentEvent.sexCategories as ArrayList<String>
        val currentProtection : ArrayList<String> = currentEvent.protection as ArrayList<String>
        val currentFeelings : ArrayList<String> = currentEvent.feelings as ArrayList<String>
        val currentSymptoms : ArrayList<String> = currentEvent.symptoms as ArrayList<String>
        val currentLog : String = currentEvent.log

        for (label in currentCategories) {
            sex_button_arr[sex_labels.indexOf(label)].isChecked = true
        }
        for (label in currentProtection) {
            protection_button_arr[protection_labels.indexOf(label)].isChecked = true
        }
        for (label in currentFeelings) {
            feelings_button_arr[feeling_labels.indexOf(label)].isChecked = true
        }
        for (label in currentSymptoms) {
            symptoms_button_arr[symptom_labels.indexOf(label)].isChecked = true
        }
        binding.newLogEditTextEdit.setText(currentLog)

        history_btn.setOnClickListener {
            findNavController().navigate(R.id.action_myLoggerEdit_to_myLogEntries)
        }
        submit_btn.setOnClickListener {
            val submit_sex : ArrayList<String> = ArrayList<String>()
            for ((index, button) in sex_button_arr.withIndex()) {
                if (button.isChecked) submit_sex.add(sex_labels[index])
            }

            val submit_protection : ArrayList<String> = ArrayList<String>()
            for ((index, button) in protection_button_arr.withIndex()) {
                if (button.isChecked) submit_protection.add(protection_labels[index])
            }

            val submit_feelings : ArrayList<String> = ArrayList<String>()
            for ((index, button) in feelings_button_arr.withIndex()) {
                if (button.isChecked) submit_feelings.add(feeling_labels[index])
            }

            val submit_symptoms : ArrayList<String> = ArrayList<String>()
            for ((index, button) in symptoms_button_arr.withIndex()) {
                if (button.isChecked) submit_symptoms.add(symptom_labels[index])
            }

            val submit_date : GregorianCalendar = GregorianCalendar()
            val submit_log : EditText = binding.newLogEditTextEdit
            val submit_log_text : String = submit_log.text.toString()

            val editedEvent = Event(submit_date, submit_sex, submit_protection,
                submit_feelings, submit_symptoms, submit_log_text)
            EventListModifier.editEvent(editedEvent)


            findNavController().navigate(R.id.action_myLoggerEdit_to_myLogEntries)
        }
    }
}