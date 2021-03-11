package com.example.intheknow.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intheknow.R
import android.graphics.Color
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import kotlinx.android.synthetic.main.fragment_my_log_graph.*

/**
 * A simple [Fragment] subclass.
 * Use the [MyLogGraph.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyLogGraph : Fragment() {


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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBarChart()
    }
    private fun setBarChart() {

        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(5f, 27f))
        entries.add(BarEntry(10f, 30f))


        val labels = mutableListOf<String>("Condom", "No Condom")
        val barDataSet = BarDataSet(entries, "Legend")
        val data = BarData(barDataSet)

        val colors = mutableListOf<Int>(Color.RED, Color.CYAN)
        barDataSet.setColors(colors)
        barChart.data = data // set the data and list of lables into chart
        data.setBarWidth(0.9f)


        barChart.description.setText("Condom")
        barChart.getAxisLeft().setAxisMinimum(0.0f)
        barChart.getAxisLeft().setAxisMaximum(50.0f)
        barChart.getAxisRight().setEnabled(false)
        barChart.getXAxis().setDrawGridLines(false)
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getXAxis().setDrawLabels(false);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM)
        barChart.getXAxis().setCenterAxisLabels(true);

        //barChart.getXAxis().valueFormatter = IAxisValueFormatter { value, axis -> labels[value.toInt()] }

        barChart.animateY(3000)
    }


}