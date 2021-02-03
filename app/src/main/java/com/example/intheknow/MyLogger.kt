package com.example.intheknow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ToggleButton

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

    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    //    val tgl_btn : ToggleButton = view.findViewById(R.id.toggleButton)
    //    if (tgl_btn.isChecked() && tgl_btn.background) {
    //        tgl_btn.setBackgroundResource(R.drawable.);
    //    }
    //}

}