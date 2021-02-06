package com.example.intheknow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ToggleButton
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [MyLogger.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyLogger : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_logger, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val history_btn : Button = view.findViewById(R.id.skip_to_log_btn)
        val submit_btn : Button = view.findViewById(R.id.new_log_submit_btn)
        history_btn.setOnClickListener {
            findNavController().navigate(R.id.action_myLogger_to_myLogEntries)
        }
        submit_btn.setOnClickListener {
            findNavController().navigate(R.id.action_myLogger_to_myLogEntries)
        }
    }

}