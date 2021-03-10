package com.example.intheknow.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues
import android.util.Log

class DBHandler(context: Context, name: String?,
                  factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, DATABASE_NAME,
        factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_USERS_TABLE = ("CREATE TABLE " +
                TABLE_USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_GENDER + " TEXT,"
                + COLUMN_SEXUALITY + " TEXT,"
                + COLUMN_DOB + " TEXT,"
                + COLUMN_FIRSTNAME + " TEXT,"
                + COLUMN_LASTNAME + " TEXT" + ")")
        db.execSQL(CREATE_USERS_TABLE)


        val CREATE_EVENTS_TABLE = ("CREATE TABLE " +
                TABLE_EVENTS + "("
                + COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_EVENT_DATE + " TEXT NOT NULL,"
                + COLUMN_SEX + " TEXT NOT NULL,"
                + COLUMN_PROTECTION + " TEXT NOT NULL,"
                + COLUMN_FEELINGS + " TEXT NOT NULL,"
                + COLUMN_SYMPTOMS + " TEXT NOT NULL,"
                + COLUMN_LOG + " TEXT NOT NULL,"
                + COLUMN_USER_ID + " INTEGER,"
                + " FOREIGN KEY ("+COLUMN_USER_ID+") REFERENCES "+TABLE_USERS+"("+COLUMN_ID+")"
                + ")")
        db.execSQL(CREATE_EVENTS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS)
        onCreate(db)
    }

    fun addUser(user: User) : Long {

        val values = ContentValues()
        values.put(COLUMN_USERNAME, user.username)
        values.put(COLUMN_PASSWORD, user.password)
        values.put(COLUMN_GENDER, user.gender)
        values.put(COLUMN_SEXUALITY, user.sexuality)
        values.put(COLUMN_DOB, user.DOB)
        values.put(COLUMN_FIRSTNAME, user.firstName)
        values.put(COLUMN_LASTNAME, user.lastName)

        val db = this.writableDatabase

        val id : Long = db.insert(TABLE_USERS, null, values)

        db.close()
        Log.i("DB", "User added")
        return id
    }

    fun queryUserByUsename(username : String) : User? {
        val query =
            "SELECT * FROM $TABLE_USERS WHERE $COLUMN_USERNAME =  \"$username\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var user: User? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            //val id = Integer.parseInt(cursor.getString(0))
            val username = cursor.getString(1)
            val password = cursor.getString(2)
            val gender = cursor.getString(3)
            val sexuality = cursor.getString(4)
            val DOB = cursor.getString(5)
            val firstName = cursor.getString(6)
            val lastName = cursor.getString(7)

            user = User(username, password, gender, sexuality, DOB, firstName, lastName)
            cursor.close()
        }

        db.close()
        return user
    }

    fun addEvent(event : Event) : Long {
        val values = ContentValues()
        values.put(COLUMN_EVENT_DATE, Converter.gregorianCalendarToDateStr(event.date))
        values.put(COLUMN_SEX, Converter.list2DBStr(event.sexCategories))
        values.put(COLUMN_PROTECTION, Converter.list2DBStr(event.protection))
        values.put(COLUMN_FEELINGS, Converter.list2DBStr(event.feelings))
        values.put(COLUMN_SYMPTOMS, Converter.list2DBStr(event.symptoms))
        values.put(COLUMN_LOG, event.log)
        values.put(COLUMN_USER_ID, UserResolver.id)

        val db = this.writableDatabase

        val id : Long = db.insert(TABLE_EVENTS, null, values)

        db.close()
        Log.i("DB", "Event added")
        return id
    }

    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "itkDB.db"

        //user table
        val TABLE_USERS = "users"
        val COLUMN_ID = "_id"
        val COLUMN_USERNAME = "username"
        val COLUMN_PASSWORD = "password"
        val COLUMN_GENDER = "gender"
        val COLUMN_SEXUALITY = "sexuality"
        val COLUMN_DOB = "dob"
        val COLUMN_FIRSTNAME = "firstname"
        val COLUMN_LASTNAME = "lastname"

        //event table
        val TABLE_EVENTS = "events"
        val COLUMN_EVENT_ID = "event_id"
        val COLUMN_USER_ID = "user_id"
        val COLUMN_EVENT_DATE = "date"
        val COLUMN_SEX = "sex categories"
        val COLUMN_PROTECTION = "protection"
        val COLUMN_FEELINGS = "feelings"
        val COLUMN_SYMPTOMS = "symptoms"
        val COLUMN_LOG = "log"

    }
}