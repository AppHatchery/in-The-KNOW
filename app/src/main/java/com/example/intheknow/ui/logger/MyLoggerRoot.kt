package com.example.intheknow.ui.logger

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.colorspace.Illuminant.A
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intheknow.R
import com.example.intheknow.data.LogEntry
import com.example.intheknow.data.LogListModifier
import com.example.intheknow.databinding.FragmentMyLoggerRootBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kotlinx.android.synthetic.main.fragment_my_log_graph.*
import kotlinx.android.synthetic.main.fragment_my_log_graph.pieChart
import kotlinx.android.synthetic.main.fragment_my_logger_root.*
import java.util.*
import kotlin.collections.ArrayList


class MyLoggerRoot : Fragment(), LogEntryAdapter.OnLogItemDeleteListener, LogEntryAdapter.OnLogItemEditListener {
    lateinit var binding: FragmentMyLoggerRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_logger_root, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycle_view_eventsRoot.layoutManager = LinearLayoutManager(context)
        recycle_view_eventsRoot.adapter = LogListModifier.adapter
        recycle_view_eventsRoot.setHasFixedSize(true)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var addNewLogBtn = binding.fabAddEvent
        addNewLogBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myLoggerRoot_to_newLogSymptomsScreen)
        }
        var toggleMyCharts = binding.toggleMyCharts
        var toggleListView = binding.toggleMyLog
        var loggerLayout = binding.LoggerLayout
        var pc = binding.pieChart
        var historyView = binding.recycleViewEventsRoot

        //default
        toggleMyCharts.isChecked = true
        toggleListView.isChecked = false
        buildChart()


        //clear build log
        LogListModifier.clearNewEntryBuild()

        toggleMyCharts.setOnClickListener {
            buildChart()
            loggerLayout.removeAllViews()
            loggerLayout.addView(binding.loggerControlBar)
            loggerLayout.addView(pc)
            toggleMyCharts.isChecked = true
            toggleListView.isChecked = false
        }
        toggleListView.setOnClickListener {
            loggerLayout.removeAllViews()
            loggerLayout.addView(binding.loggerControlBar)
            loggerLayout.addView(historyView)
            historyView.visibility = View.VISIBLE
            toggleMyCharts.isChecked = false
            toggleListView.isChecked = true
        }


    }

    override fun onResume() {
        super.onResume()
        binding.toggleMyCharts.isChecked = true
        binding.toggleMyLog.isChecked = false
    }

    @SuppressLint("NewApi")
    fun buildChart() {
        pieChart.setUsePercentValues(true)
        val xvalues = ArrayList<PieEntry>()
        xvalues.add(PieEntry(34.0f, "Vaginal"))
        xvalues.add(PieEntry(28.2f, "Anal"))
        xvalues.add(PieEntry(37.9f, "Oral"))

        var lightSalmon = Color.valueOf(1.0f, 0.625f, 0.4765625f)
        var deepBlue = Color.valueOf(0f, 0.7461f, 1.0f)
        var plum = Color.valueOf(0.86328f, 0.625f, 0.86328f)

        val colors = mutableListOf<Int>(lightSalmon.toArgb(), deepBlue.toArgb(), plum.toArgb())
        val dataSet = PieDataSet(xvalues, "")
        val data = PieData(dataSet)
        dataSet.setColors(colors)
        // In Percentage
        data.setValueFormatter(PercentFormatter())

        pieChart.data = data
        pieChart.description.text = "Sexual Activity Chart"
        pieChart.isDrawHoleEnabled = true
        data.setValueTextSize(17f)
    }

    override fun onLogItemDelete(position: Int) {
        LogListModifier.deleteEvent(position)
    }

    override fun onLogItemEdit(position: Int, itemView: View) {
        LogListModifier.itemSelector = position
        //itemView.findNavController().navigate(R.id.action_myLogEntries_to_myLoggerEdit)
    }




    private fun generateDummyLog(size : Int): ArrayList<LogEntry> {

        val list = ArrayList<LogEntry>()

        var year = 20
        var month = 0
        var day = 7

        val occurenceArray : Array<Boolean> = arrayOf(true, false)
        val eventArray: Array<String> = arrayOf(LogEntry.ANAL, LogEntry.VAGINAL, LogEntry.ORAL, LogEntry.NON_PENETRATIVE)

        val protectionArray : Array<Int> = arrayOf(LogEntry.NO_CONDOM, LogEntry.CONDOM, LogEntry.CONDOM_UNSPECIFIED)

        val symptomsArray: Array<String> = arrayOf(LogEntry.MISSED_PERIOD, LogEntry.VAGINAL_BURNING,
            LogEntry.VAGINAL_ITCHING, LogEntry.VAGINAL_DISCHARGE, LogEntry.VAGINAL_ODOR, LogEntry.PAIN,
            LogEntry.FEVER, LogEntry.BLEEDING, LogEntry.RASHES)

        val commentsList : ArrayList<String> = arrayListOf<String>("Sticking to my goals", "Feeling all right",
            "Haven't been sticking to goals", "Feel healthy", "Went to sleep just fine", "Had trouble falling asleep")

        for (i in 0 until size) {
            //populate random date
            val date : GregorianCalendar = GregorianCalendar(year + 2000, month, day)
            month = month + (0..5).random()
            if (month >= 12) {
                year += 1
                month = month % 12
            }
            day = (0..28).random()

            val sex = occurenceArray[(0..1).random()]

            //populate random symptom
            val symptoms = ArrayList<String>()
            for (j in 0..(symptomsArray.size - 1)) {
                val symptomFlag = (0..1).random()
                if (symptomFlag == 1) {
                    symptoms.add(symptomsArray[j])
                }
            }

            val sexCategory = eventArray[(0..3).random()]
            val protection = protectionArray[(0..2).random()]

            //populate random text
            val randomText = commentsList.get((0..5).random())

            val logEntry = LogEntry(date, symptoms, sex, 0, sexCategory, protection, randomText)
            list += logEntry
        }
        return list
    }



}