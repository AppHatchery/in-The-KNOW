package com.apphatchery.intheknow.ui.logger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.apphatchery.intheknow.App
import com.apphatchery.intheknow.R
import com.apphatchery.intheknow.data.SymptomEntry
import com.apphatchery.intheknow.data.UserResolver
import com.apphatchery.intheknow.databinding.FragmentNewLogSymptomsScreenBinding
import com.google.android.material.checkbox.MaterialCheckBox
import java.util.*


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
        var cbVD : MaterialCheckBox = binding.vaginalDischarge
        var cbPain : MaterialCheckBox = binding.painSex
        var cbAbPain : MaterialCheckBox = binding.abdomenalPain
        var cbAbVagB : MaterialCheckBox = binding.vaginalBleeding
        var cbRashes : MaterialCheckBox = binding.rashes
        var cbFev : MaterialCheckBox = binding.fever

        var symptomEntry : SymptomEntry = SymptomEntry(GregorianCalendar(), arrayListOf())
        var symptomsList = arrayListOf<String>()

        val nextBtn : AppCompatImageButton = binding.nextQ1 as AppCompatImageButton

        nextBtn.setOnClickListener {

            if (cbMP.isChecked) symptomsList.add(SymptomEntry.MISSED_PERIOD)
            if (cbVI.isChecked) symptomsList.add(SymptomEntry.VAGINAL_ITCHING)
            if (cbVB.isChecked) symptomsList.add(SymptomEntry.VAGINAL_BURNING)
            if (cbVO.isChecked) symptomsList.add(SymptomEntry.VAGINAL_ODOR)
            if (cbVD.isChecked) symptomsList.add(SymptomEntry.VAGINAL_DISCHARGE)
            if (cbPain.isChecked) symptomsList.add(SymptomEntry.PAIN)
            if (cbAbPain.isChecked) symptomsList.add(SymptomEntry.AB_PAIN)
            if (cbAbVagB.isChecked) symptomsList.add(SymptomEntry.BLEEDING)
            if (cbRashes.isChecked) symptomsList.add(SymptomEntry.RASHES)
            if (cbFev.isChecked) symptomsList.add(SymptomEntry.FEVER)

            symptomEntry.symptoms = symptomsList
            App.getDB().addSymptomEntry(UserResolver.id, symptomEntry)

            findNavController().navigate(R.id.action_newLogSymptomsScreen_to_loggerRoot)
        }
    }
}