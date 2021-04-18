package com.example.intheknow.ui.logger

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.LogListModifier
import com.example.intheknow.databinding.FragmentNewLogTimeScreenBinding


/**
 * A simple [Fragment] subclass.
 * Use the [NewLogTimeScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewLogTimeScreen : Fragment() {

    lateinit var binding: FragmentNewLogTimeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_log_time_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sex = true
        var sexSelected = false
        var timeFrameSelected = false

        val yesBtn : Button = binding.YesSex
        val noBtn : Button = binding.NoSex

        val existingSexQuery = LogListModifier.newEntryBuild.sex
        val existingTimeFrameStart = LogListModifier.newEntryBuild.timeFrameStart
        if (existingSexQuery) {
            sexSelected = true
            timeFrameSelected = true
            binding.newLoggerQ2Recency.visibility = View.VISIBLE
            binding.recencyRadioGroup.visibility = View.VISIBLE
            if (existingTimeFrameStart == 0) {
                binding.todayRadioBtn.isChecked = true
            } else if (existingTimeFrameStart == 1) {
                binding.pastWeekRadioBtn.isChecked = true
            } else {
                binding.pastMonthRadioBtn.isChecked = true
            }
        }

        yesBtn.setOnClickListener {
            sexSelected = true
            //yesBtn.backgroundTintList = Color.valueOf(1.0f, 0.625f, 0.4765625f) as ColorStateList
            binding.newLoggerQ2Recency.visibility = View.VISIBLE
            binding.recencyRadioGroup.visibility = View.VISIBLE
        }
        noBtn.setOnClickListener {
            sexSelected = true
            sex = false
            binding.newLoggerQ2Recency.visibility = View.INVISIBLE
            binding.recencyRadioGroup.visibility = View.INVISIBLE
        }


        var timeFrame = 0
        binding.todayRadioBtn.setOnClickListener {
            timeFrameSelected = true
        }
        binding.pastWeekRadioBtn.setOnClickListener {
            timeFrameSelected = true
            timeFrame = 1
        }
        binding.pastMonthRadioBtn.setOnClickListener {
            timeFrameSelected = true
            timeFrame = 2
        }

        val nextBtn : AppCompatImageButton = binding.nextQ2 as AppCompatImageButton
        nextBtn.setOnClickListener {
            if (sexSelected && !sex) {
                Log.i("Debug", "Skip to End")
                LogListModifier.newEntryBuild.sex = false
                LogListModifier.addEvent()
                findNavController().navigate(R.id.action_newLogTimeScreen_to_newLogCompletionScreen)
            } else if (sexSelected && timeFrameSelected && sex) {
                LogListModifier.newEntryBuild.sex = true
                LogListModifier.newEntryBuild.timeFrameStart = timeFrame
                findNavController().navigate(R.id.action_newLogTimeScreen_to_newLogDetailsScreen)
            }

        }
    }
}