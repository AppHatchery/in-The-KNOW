package com.example.intheknow.ui.logger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intheknow.R
import com.example.intheknow.data.Event
import kotlinx.android.synthetic.main.logger_list_item.view.*
import java.util.*

class EventAdapter(
        private val eventList : List<Event>,
        private val deleteListener : OnItemDeleteListener,
        private val editListener : OnItemEditListener
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

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
                R.id.condom_btn -> "condom"
                R.id.no_condom_btn -> "no condom"
                R.id.oral_btn -> "oral"
                else -> "by myself"
            }
            eventsStr += eStr + ", "
        }
        eventsStr = eventsStr.substringBeforeLast(",")
        holder.summaryLine.text = eventsStr

    }

    override fun getItemCount() = eventList.size

    inner class EventViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
        val dateLine : TextView = itemView.findViewById(R.id.event_date)
        val summaryLine : TextView = itemView.findViewById(R.id.event_summary)

        init {
            itemView.btnDelete.setOnClickListener(this)
            itemView.btnEdit.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position : Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (v != null) {
                    if (v.id == R.id.btnDelete) {
                        deleteListener.onItemDelete(position)
                    }
                    else {
                        editListener.onItemEdit(position, itemView)
                    }
                }
            }
        }

    }

    interface OnItemDeleteListener {
        fun onItemDelete(position: Int)
    }
    interface OnItemEditListener {
        fun onItemEdit(position: Int, itemView : View)
    }
}