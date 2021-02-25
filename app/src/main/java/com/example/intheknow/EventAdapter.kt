package com.example.intheknow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.Month
import java.util.*
import kotlin.collections.HashMap

class EventAdapter(private val eventList : List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.logger_list_item,
            parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentItem = eventList[position]
        val calendar : GregorianCalendar = currentItem.date
        val year = calendar.get(GregorianCalendar.YEAR)
        val month = calendar.get(GregorianCalendar.MONTH) + 1
        val day = calendar.get(GregorianCalendar.DAY_OF_MONTH)
        var calendarFormatter = "%d/%d/%d"
        holder.dateLine.text = calendarFormatter.format(month, day, year)

        val eventsSet = currentItem.sexCategories
        var eventsStr = ""
        for (event in eventsSet) {
            var eStr = when (event) {
                2131362142 -> "condom"
                2131361956 -> "no condom"
                2131362150 -> "oral"
                else -> "by myself"
            }
            eventsStr += eStr + ", "
        }
        eventsStr = eventsStr.substringBeforeLast(",")
        holder.summaryLine.text = eventsStr

    }

    override fun getItemCount() = eventList.size

    class EventViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val dateLine : TextView = itemView.findViewById(R.id.event_date)
        val summaryLine : TextView = itemView.findViewById(R.id.event_summary)

    }

}