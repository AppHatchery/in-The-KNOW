package com.example.intheknow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [StartDestination.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartDestination : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_destination, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val logger_btn : Button = view.findViewById(R.id.my_logger_btn)
        val tests_btn : Button = view.findViewById(R.id.my_tests_btn)
        logger_btn.setOnClickListener {
            findNavController().navigate(R.id.action_startDestination_to_myLogger)
        }
        tests_btn.setOnClickListener {
            findNavController().navigate(R.id.action_startDestination_to_myTests)
        }
    }
}