package com.example.intheknow.ui.logger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.LogEntry
import com.example.intheknow.data.LogListModifier
import com.example.intheknow.databinding.FragmentNewLogDetailsScreenBinding


/**
 * A simple [Fragment] subclass.
 * Use the [NewLogDetailsScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewLogDetailsScreen : Fragment() {

    lateinit var binding: FragmentNewLogDetailsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_log_details_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sexCategory = ""
        var condom = 0

        var vaginal_btn = binding.vaginalRadioBtn
        var anal_btn = binding.analRadioBtn
        var oral_btn = binding.oralRadioBtn
        val other_btn = binding.otherRadioBtn


        vaginal_btn.setOnClickListener {
            sexCategory = LogEntry.VAGINAL
        }
        anal_btn.setOnClickListener {
            sexCategory = LogEntry.ANAL
        }
        oral_btn.setOnClickListener {
            sexCategory = LogEntry.ORAL
        }
        other_btn.setOnClickListener {
            binding.editTextSexCategory.visibility = View.VISIBLE
        }

        var condom_btn = binding.yesCondomRadioBtn
        var no_condom_btn = binding.noCondomRadioBtn
        var rns_btn = binding.condomUndefined
        var condom_selected = false

        condom_btn.setOnClickListener {
            condom = LogEntry.CONDOM
            condom_selected = true
        }

        no_condom_btn.setOnClickListener {
            condom = LogEntry.NO_CONDOM
            condom_selected = true
        }

        rns_btn.setOnClickListener {
            LogEntry.CONDOM_UNSPECIFIED
            condom_selected = true
        }

        val prevBtn : AppCompatImageButton = binding.prevQ3 as AppCompatImageButton
        prevBtn.setOnClickListener {
            findNavController().navigate(R.id.action_newLogDetailsScreen_to_newLogTimeScreen)
        }


        val nextBtn : AppCompatImageButton = binding.nextQ3 as AppCompatImageButton
        nextBtn.setOnClickListener {
            if(condom_selected) {
                LogListModifier.newEntryBuild.condom = condom
                if (sexCategory == "") {
                    if (binding.editTextSexCategory.text.toString() != "") {
                        sexCategory = binding.editTextSexCategory.text.toString()
                        LogListModifier.newEntryBuild.sexCategory = sexCategory
                        LogListModifier.addEvent()
                        findNavController().navigate(R.id.action_newLogDetailsScreen_to_newLogCompletionScreen)
                    }
                } else {
                    LogListModifier.newEntryBuild.sexCategory = sexCategory
                    LogListModifier.addEvent()
                    findNavController().navigate(R.id.action_newLogDetailsScreen_to_newLogCompletionScreen)
                }
            }

        }


    }
}