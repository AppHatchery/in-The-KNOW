package com.example.intheknow.data

import java.util.*

class Converter {

    companion object {
        fun gregorianCalendarToDateStr(calendar: GregorianCalendar) : String {
            var calendarFormatter = "%d/%d/%d"
            return calendarFormatter.format(calendar.get(GregorianCalendar.MONTH) + 1,
                calendar.get(GregorianCalendar.DAY_OF_MONTH),
                calendar.get(GregorianCalendar.YEAR))
        }

        fun dateStrToGregorianCalendar(date : String) : GregorianCalendar {
            return GregorianCalendar()
        }


    }
}