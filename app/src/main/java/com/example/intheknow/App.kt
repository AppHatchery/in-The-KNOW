package com.example.intheknow

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import com.example.intheknow.data.DBHandler


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = DBHandler(applicationContext, null, null, 1)
    }

    companion object {
        var db: DBHandler? = null
        fun getDB(): DBHandler {
            return db!!
        }
    }
}