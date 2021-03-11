package com.example.intheknow.ui.logger

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ToggleButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.Event
import com.example.intheknow.data.EventListModifier
import com.example.intheknow.databinding.FragmentMyLoggerBinding
import java.util.*
import kotlin.collections.HashSet

/**
 * A simple [Fragment] subclass.
 * Use the [MyLogger.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyLogger : Fragment() {
    lateinit var binding: FragmentMyLoggerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_logger, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val history_btn : Button = binding.skipToLogBtn
        val submit_btn : Button = binding.newLogSubmitBtn

        //parallel arrays
        val sex_button_arr : Array<ToggleButton> = arrayOf(binding.vaginalBtn,
            binding.analBtn, binding.oralBtn, binding.nonPenetrativeBtn)
        val sex_labels : Array<String> = arrayOf(Event.VAGINAL, Event.ANAL, Event.ORAL, Event.NON_PENETRATIVE)

        val protection_button_arr : Array<ToggleButton> = arrayOf(binding.withdrawalBtn,
            binding.condomBtn, binding.fertilityAwarenessBtn, binding.progestinOnlyBtn,
            binding.cocContraceptiveBtn, binding.IUDBtn, binding.vaginalRingBtn, binding.patchBtn)
        val protection_labels : Array<String> = arrayOf(Event.WITHDRAWAL, Event.CONDOM, Event.FERTILITY_AWARENESS,
            Event.MINI_PILL, Event.COMBO_PILL, Event.IUD, Event.RING, Event.PATCH)

        val feelings_button_arr : Array<ToggleButton> = arrayOf(binding.greatBtn, binding.depressedBtn,
            binding.nervousBtn, binding.anxiousBtn, binding.tiredBtn, binding.motivatedBtn, binding.angryBtn, binding.ehBtn)
        val feeling_labels : Array<String> = arrayOf(Event.GREAT, Event.DEPRESSED, Event.NERVOUS, Event.ANXIOUS,
            Event.TIRED, Event.MOTIVATED, Event.ANGRY, Event.EH)

        val symptoms_button_arr : Array<ToggleButton> = arrayOf(binding.nauseaBtn, binding.nightsweatsBtn,
            binding.mouthsoresBtn, binding.vomitingBtn, binding.muscleAchesBtn, binding.jointPainBtn,
            binding.infectionBtn, binding.soreThroat)
        val symptom_labels : Array<String> = arrayOf(Event.NAUSEA, Event.NIGHT_SWEATS, Event.MOUTH_SORES,
            Event.VOMITING, Event.MUSCLE_ACHES, Event.JOINT_PAIN, Event.INFECTION, Event.SORE_THROAT)

        history_btn.setOnClickListener {
            findNavController().navigate(R.id.action_myLogger_to_myLogEntries)
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
            val submit_log : EditText = binding.newLogEditText
            val submit_log_text : String = submit_log.text.toString()

            Log.d("SIZE", " " + EventListModifier.eventList.size)
            val newEvent = Event(submit_date, submit_sex, submit_protection,
                submit_feelings, submit_symptoms, submit_log_text)
            EventListModifier.addEvent(newEvent)
            Log.d("SIZE", " " + EventListModifier.eventList.size)
            Log.d("TEST", "" + EventListModifier.eventList[0].log)
            Log.d("TEST2", "" + EventListModifier.eventList[0].sexCategories.sorted()[0])




            findNavController().navigate(R.id.action_myLogger_to_myLogEntries)
        }

    }

}