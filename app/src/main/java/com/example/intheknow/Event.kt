package com.example.intheknow

import android.util.Log
import java.util.*

data class Event (val date : GregorianCalendar, val sexCategories: Set<Int>, val feelings: Set<Int>, val symptoms: Set<Int>, val log: String)


class EventListModifier {
    companion object {
        var eventList : ArrayList<Event> = ArrayList<Event>()
        val adapter = EventAdapter(eventList, MyLogEntries())

        fun addEvent(e : Event) {
            Log.d("Starting add", "ADD")
            var pos : Int = eventList.size
            eventList.add(e)
            adapter.notifyItemInserted(pos)
            Log.d("After Add Size", "" + eventList.size)
        }

        fun deleteEvent(position: Int) {
            Log.d("Starting delete", "DELETE")
            eventList.removeAt(position)
            adapter.notifyItemRemoved(position)
            Log.d("After Delete Size", "" + eventList.size)
        }
    }
}