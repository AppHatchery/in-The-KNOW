package com.apphatchery.intheknow.data

//updated data class for MyLogger
import android.util.Log
import com.apphatchery.intheknow.ui.logger.LogEntryAdapter
import com.apphatchery.intheknow.ui.logger.MyLoggerRoot

import java.util.*

data class LogEntry (
    var dateOfEntry : GregorianCalendar,
    var sex: Boolean,
    var timeFrameStart : Int,
    var sexCategory: String,
    var condom: Int,
    var log: String
) {
    companion object {
        //define sex categories
        val VAGINAL = "Vaginal" ; val ANAL = "Anal" ; val ORAL = "Oral" ; val NON_PENETRATIVE = "No Penetration"
        //define protection
        val NO_CONDOM = 0 ; val CONDOM = 1 ;val CONDOM_UNSPECIFIED = 2
    }
}


class LogListModifier {
    companion object {
        var logList : ArrayList<LogEntry> = ArrayList<LogEntry>()
        val adapter = LogEntryAdapter(logList, MyLoggerRoot(), MyLoggerRoot())
        var itemSelector : Int = 0
        var newEntryBuild : LogEntry = LogEntry(GregorianCalendar(), false, 0, "No Sex", 0, "")

        fun clearNewEntryBuild(){
            newEntryBuild = LogEntry(GregorianCalendar(), false, 0, "No Sex", 0, "")
        }

        fun addEvent() {
            Log.d("Starting add", "ADD")
            //App.getDB().addEvent(UserResolver.id, e)
            var pos : Int = logList.size
            logList.add(newEntryBuild)
            adapter.notifyItemInserted(pos)
            Log.d("After Add Size", "" + logList.size)
        }

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