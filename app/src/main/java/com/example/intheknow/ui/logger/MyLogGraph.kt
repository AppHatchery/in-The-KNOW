package com.example.intheknow.ui.logger

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
//import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.intheknow.R
import com.github.mikephil.charting.data.*
import kotlinx.android.synthetic.main.fragment_my_log_graph.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.random.Random



/**
 * A simple [Fragment] subclass.
 * Use the [MyLogGraph.newInstance] factory method to
 * create an instance of this fragment.
 */

class MyLogGraph : Fragment() {
    //val <GregorianCalendar, String> hashMapOf(): HashMap<GregorianCalendar, String>
    var hashMap : HashMap<Long, String>
            = HashMap<Long, String> ()
    val arr = intArrayOf(0x1F60A, 0x1F602, 0x1F607, 0x1F610, 0x1F612, 0x1F62C, 0x1F614, 0x1F634,
        0x1F615, 0x1F630, 0x1F62D, 0x1F62B, 0x1F60D, 0x1F633)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_log_graph, container, false)
    }
    fun getEmoji(unicode: Int): String {
        return String(Character.toChars(unicode))
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val FeelingEventButton : Button = view.findViewById(R.id.FeelingEventButton)

        FeelingEventButton.setOnClickListener {
            findNavController().navigate(R.id.action_myLogGraph_to_createEmoji)
        }
        super.onViewCreated(view, savedInstanceState)
        val calendarView = view.findViewById(R.id.calendarView) as CalendarView
        val test = view.findViewById(R.id.testbox) as TextView
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            run {
                if (test != null) {
                    if (dayOfMonth == 26) {
                        test.text = getEmoji(0x1F60A)
                    } else {
                        test.text = getEmoji(arr[Random.nextInt(14)])
                    }
                }
            }
        }
    }
}
