package com.apphatchery.intheknow.data

import java.util.*

class Converter {

    companion object {

        fun gregorianCalendarToDateStr(calendar: GregorianCalendar) : String {
            val date : Date = calendar.time
            val formatter = java.text.SimpleDateFormat("yyyy-MM-dd HH-mm")
            return formatter.format(date)
        }

        fun gregorianCalendarToPrettyStr(calendar: GregorianCalendar) : String {
            val now : GregorianCalendar = GregorianCalendar()
            val yearSpecifier = GregorianCalendar.YEAR
            val monthSpecifier = GregorianCalendar.MONTH
            val weekSpecifier = GregorianCalendar.WEEK_OF_MONTH
            val daySpecifier = GregorianCalendar.DAY_OF_WEEK
            if (calendar.get(GregorianCalendar.YEAR) < now.get(GregorianCalendar.YEAR)) {
                return "Last Year"
            }
            if (now.get(monthSpecifier) == calendar.get(monthSpecifier) &&
                    now.get(weekSpecifier) == calendar.get(weekSpecifier)) {
                 if (now.get(daySpecifier) == 1 + calendar.get(daySpecifier)) {
                     return "Yesterday"
                 }
                if (now.get(daySpecifier) == calendar.get(daySpecifier)) {
                    return "Today"
                }
                return calendar.getDisplayName(daySpecifier, GregorianCalendar.LONG, Locale.US)!!

            }
            var monthShort = calendar.getDisplayName(monthSpecifier, GregorianCalendar.SHORT, Locale.US)!!
            var display = monthShort + " " + calendar.get(GregorianCalendar.DAY_OF_MONTH).toString()
            return display
        }

        fun dateStrToGregorianCalendar(dateStr : String) : GregorianCalendar {
            val fmt = java.text.SimpleDateFormat("yyyy-MM-dd HH-mm")
            val date = fmt.parse(dateStr)
            var cal: GregorianCalendar = GregorianCalendar.getInstance() as GregorianCalendar
            cal.time = date
            return cal
        }

        fun list2DBStr(list : List<String>) : String {
            return list.joinToString(",")
        }

        fun DBStr2List(str : String) : List<String> {
            var retList : ArrayList<String> = arrayListOf()
            var startIdx : Int = 0
            var endIdx : Int = str.indexOf(",", startIdx)
            while (endIdx >= 0) {
                retList.add(str.substring(startIdx, endIdx))
                startIdx = endIdx + 1
                endIdx = str.indexOf(",", startIdx)
            }
            var finStr : String = str.substring(startIdx, str.length)
            if (finStr.length > 0) {
                retList.add(finStr)
            }
            return retList
        }


    }
}