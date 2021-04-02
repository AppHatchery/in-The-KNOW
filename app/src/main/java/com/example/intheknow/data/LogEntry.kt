package com.example.intheknow.data

//updated data class for MyLogger
import android.util.Log
import com.example.intheknow.App
import com.example.intheknow.ui.logger.LogEntryAdapter
import com.example.intheknow.ui.logger.MyLoggerRoot

import java.util.*

data class LogEntry (
    val dateOfEntry : GregorianCalendar,
    val symptoms: List<String>,
    val sex: Boolean,
    val timeFrameStart : GregorianCalendar,
    val sexCategory: String,
    val condom: Int,
    val log: String
) {
    companion object {
        //define symptoms
        val MISSED_PERIOD = "missed period"; val VAGINAL_ITCHING = "vaginal itching"
        val VAGINAL_BURNING = "vaginal burning"; val VAGINAL_ODOR = "vaginal odor"
        val VAGINAL_DISCHARGE = "vaginal discharge"; val PAIN = "pain during intercourse"
        val BLEEDING = "abnormal vaginal bleeding"; val FEVER = "fever"
        val RASHES = "skin changes/rashes"
        //define sex categories
        val VAGINAL = "vaginal" ; val ANAL = "anal" ; val ORAL = "oral" ; val NON_PENETRATIVE = "no penetration"
        //define protection
        val NO_CONDOM = 0 ; val CONDOM = 1 ;val CONDOM_UNSPECIFIED = 2
    }
}


class LogListModifier {
    companion object {
        var logList : ArrayList<LogEntry> = ArrayList<LogEntry>()
        val adapter = LogEntryAdapter(logList, MyLoggerRoot(), MyLoggerRoot())
        var itemSelector : Int = 0

        fun addEvent(e : LogEntry) {
            Log.d("Starting add", "ADD")
            //App.getDB().addEvent(UserResolver.id, e)
            var pos : Int = logList.size
            logList.add(e)
            adapter.notifyItemInserted(pos)
            Log.d("After Add Size", "" + logList.size)
        }

        fun deleteEvent(position: Int) {
            //App.getDB().deleteEvent(UserResolver.id, eventList[position])
            Log.d("Starting delete", "DELETE")
            logList.removeAt(position)
            adapter.notifyItemRemoved(position)
            Log.d("After Delete Size", "" + logList.size)
        }

        fun editEvent(e : LogEntry) {
            Log.d("Starting edit", "EDIT")
            Log.d("Edit index: ", " " + itemSelector)
            if (itemSelector >= 0 && itemSelector < logList.size){
                //App.getDB().updateEvent(UserResolver.id, eventList[itemSelector], e)
                logList[itemSelector] = e
                adapter.notifyItemChanged(itemSelector)
            }
            Log.d("After Edit", "EDIT COMPLETED")
        }

        /*
        fun setupEventList(queriedList : ArrayList<Event>) {
            for (event in queriedList) {
                eventList.add(event)
            }
            adapter.notifyItemRangeInserted(0, queriedList.size)
            Log.d("After Setup", "SETUP COMPLETED")
        }
         */

    }
}