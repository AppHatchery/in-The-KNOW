package com.example.intheknow.ui.logger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.LogEntry
import com.example.intheknow.data.LogListModifier
import com.example.intheknow.databinding.FragmentMyLoggerRootBinding
import com.example.intheknow.databinding.FragmentNewLogSymptomsScreenBinding
import com.google.android.material.checkbox.MaterialCheckBox


/**
 * A simple [Fragment] subclass.
 * Use the [NewLogSymptomsScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewLogSymptomsScreen : Fragment() {
    lateinit var binding: FragmentNewLogSymptomsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_log_symptoms_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var cbMP : MaterialCheckBox = binding.missedPeriod
        var cbVI : MaterialCheckBox = binding.vaginalItching
        var cbVB : MaterialCheckBox = binding.vaginalBurning
        var cbVO : MaterialCheckBox = binding.vaginalOdor
        var cbPain : MaterialCheckBox = binding.painSex
        var cbAbPain : MaterialCheckBox = binding.abdomenalPain
        var cbAbVagB : MaterialCheckBox = binding.vaginalBleeding
        var cbFev : MaterialCheckBox = binding.fever

        var symptomsList : ArrayList<String> = LogListModifier.newEntryBuild.symptoms as ArrayList<String>
        for (s in symptomsList) {
            if (s.equals(LogEntry.MISSED_PERIOD)) cbMP.isChecked = true
            if (s.equals(LogEntry.VAGINAL_ITCHING)) cbVI.isChecked = true
            if (s.equals(LogEntry.VAGINAL_BURNING)) cbVB.isChecked = true
            if (s.equals(LogEntry.VAGINAL_ODOR)) cbVO.isChecked = true
            if (s.equals(LogEntry.PAIN)) cbPain.isChecked = true
            if (s.equals(LogEntry.AB_PAIN)) cbAbPain.isChecked = true
            if (s.equals(LogEntry.BLEEDING)) cbAbVagB.isChecked = true
            if (s.equals(LogEntry.FEVER)) cbFev.isChecked = true
        }

        val nextBtn : AppCompatImageButton = binding.nextQ1 as AppCompatImageButton

        nextBtn.setOnClickListener {

            if (cbMP.isChecked) symptomsList.add(LogEntry.MISSED_PERIOD)
            if (cbVI.isChecked) symptomsList.add(LogEntry.VAGINAL_ITCHING)
            if (cbVB.isChecked) symptomsList.add(LogEntry.VAGINAL_BURNING)
            if (cbVO.isChecked) symptomsList.add(LogEntry.VAGINAL_ODOR)
            if (cbPain.isChecked) symptomsList.add(LogEntry.PAIN)
            if (cbAbPain.isChecked) symptomsList.add(LogEntry.AB_PAIN)
            if (cbAbVagB.isChecked) symptomsList.add(LogEntry.BLEEDING)
            if (cbFev.isChecked) symptomsList.add(LogEntry.FEVER)

            LogListModifier.newEntryBuild.symptoms = symptomsList

            findNavController().navigate(R.id.action_newLogSymptomsScreen_to_newLogTimeScreen)
        }
    }
}