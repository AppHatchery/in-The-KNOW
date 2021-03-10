package com.example.intheknow.data

import android.util.Log

import com.example.intheknow.ui.logger.EventAdapter
import com.example.intheknow.ui.logger.MyLogEntries
import java.util.*

data class Event (
        val date : GregorianCalendar,
        val sexCategories: Set<Int>,
        val feelings: Set<Int>,
        val symptoms: Set<Int>,
        val log: String
)


class EventListModifier {
    companion object {
        var eventList : ArrayList<Event> = ArrayList<Event>()
        val adapter = EventAdapter(eventList, MyLogEntries(), MyLogEntries())
        var itemSelector : Int = 0

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

        fun editEvent(e : Event) {
            Log.d("Starting edit", "EDIT")
            Log.d("Edit index: ", " " + itemSelector)
            if (itemSelector >= 0 && itemSelector < eventList.size){
                eventList[itemSelector] = e
                adapter.notifyItemChanged(itemSelector)
            }
            Log.d("After Edit", "EDIT COMPLETED")
        }
    }
}