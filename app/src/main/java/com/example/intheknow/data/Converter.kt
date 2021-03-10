package com.example.intheknow.data

import android.icu.text.SimpleDateFormat
import java.util.*

class Converter {

    companion object {

        fun gregorianCalendarToDateStr(calendar: GregorianCalendar) : String {
            val date : Date = calendar.time
            val formatter = java.text.SimpleDateFormat("yyyy-MM-dd HH-mm")
            return formatter.format(date)
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
            return str.split(",")
        }


    }
}