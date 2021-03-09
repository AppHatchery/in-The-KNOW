package com.example.intheknow.data

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): GregorianCalendar? {
        //TODO: Write Conversion
        return GregorianCalendar()
    }

    @TypeConverter
    fun dateToTimestamp(date: GregorianCalendar?): Long? {
        //TODO: Write Conversion
        return 0
    }
}