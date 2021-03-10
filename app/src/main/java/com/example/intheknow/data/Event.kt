package com.example.intheknow.data

import android.util.Log

import com.example.intheknow.ui.logger.EventAdapter
import com.example.intheknow.ui.logger.MyLogEntries
import java.util.*

data class Event (
        val date : GregorianCalendar,
        val sexCategories: List<String>,
        val protection: List<String>,
        val feelings: List<String>,
        val symptoms: List<String>,
        val log: String
) {
    companion object {
        //define sex categories
        val VAGINAL = "vaginal" ; val ANAL = "anal" ; val ORAL = "oral" ; val NON_PENETRATIVE = "no penetration"
        //define protection
        val WITHDRAWAL = "withdrawal" ; val CONDOM = "condom" ; val FERTILITY_AWARENESS = "fertility awareness"; val MINI_PILL = "mini pill"
        val COMBO_PILL = "combo pill" ;val IUD = "IUD" ; val RING = "ring" ;val PATCH = "patch"
        //define feelings
        val GREAT = "great" ; val DEPRESSED = "depressed" ; val NERVOUS = "nervous" ; val ANXIOUS = "anxious"
        val TIRED = "tired" ; val MOTIVATED = "motivated" ; val ANGRY = "angry" ; val EH = "eh"
        //define symptoms
        val NAUSEA = "nausea" ; val NIGHT_SWEATS = "night sweats" ; val MOUTH_SORES = "mouth sores" ; val VOMITING = "vomiting"
        val MUSCLE_ACHES = "muscle aches" ; val JOINT_PAIN = "joint pain" ; val INFECTION = "infection" ; val SORE_THROAT = "sore throat"
    }
}


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