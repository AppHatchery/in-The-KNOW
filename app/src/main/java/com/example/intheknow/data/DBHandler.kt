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

    fun queryUserIDByUsername(username : String) : Long? {
        val query = "SELECT $COLUMN_ID FROM $TABLE_USERS WHERE $COLUMN_USERNAME =  \"$username\""
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var id : Long = -1
        if (cursor.moveToFirst()) {
            cursor.moveToFirst()
            id = (cursor.getString(0)).toLong()
            cursor.close()
        }

        db.close()
        return id
    }

    fun queryUserByUsername(username : String) : User? {
        val query =
            "SELECT * FROM $TABLE_USERS WHERE $COLUMN_USERNAME =  \"$username\""

        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var user: User? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()
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

    fun addEvent(UserID: Long, event : Event) : Long {
        var values = ContentValues()
        values.put(COLUMN_EVENT_DATE, Converter.gregorianCalendarToDateStr(event.date))
        values.put(COLUMN_SEX, Converter.list2DBStr(event.sexCategories))
        values.put(COLUMN_PROTECTION, Converter.list2DBStr(event.protection))
        values.put(COLUMN_FEELINGS, Converter.list2DBStr(event.feelings))
        values.put(COLUMN_SYMPTOMS, Converter.list2DBStr(event.symptoms))
        values.put(COLUMN_LOG, event.log)
        values.put(COLUMN_USER_ID, UserID)

        Log.d("Feelings: ", values.get(COLUMN_FEELINGS) as String)

        val db = this.writableDatabase

        val id : Long = db.insert(TABLE_EVENTS, null, values)

        db.close()
        Log.i("DB", "Event added")
        return id
    }

    fun deleteEvent(UserID: Long, event : Event) : Boolean {
        var result = false

        val dateEventID = Converter.gregorianCalendarToDateStr(event.date)

        val query = "SELECT * FROM $TABLE_EVENTS WHERE $COLUMN_USER_ID = \"$UserID\" " +
                "AND $COLUMN_EVENT_DATE = \"$dateEventID\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            val event_id = Integer.parseInt(cursor.getString(0))
            db.delete(
                TABLE_EVENTS, COLUMN_EVENT_ID + " = ?",
                arrayOf(event_id.toString()))
            cursor.close()
            result = true
        }
        db.close()
        return result
    }

    fun updateEvent(UserID: Long, event : Event, newEvent : Event) {
        val str_date = Converter.gregorianCalendarToDateStr(newEvent.date)
        val str_sex = Converter.list2DBStr(newEvent.sexCategories)
        val str_protection = Converter.list2DBStr(newEvent.protection)
        val str_feelings = Converter.list2DBStr(newEvent.feelings)
        val str_symptoms = Converter.list2DBStr(newEvent.symptoms)
        val log = newEvent.log

        val oldEventDate = Converter.gregorianCalendarToDateStr(event.date)
        val updateQuery =
            "UPDATE $TABLE_EVENTS SET " +
                    "$COLUMN_EVENT_DATE =  \"$str_date\", " +
                    "$COLUMN_SEX = \"$str_sex\", " +
                    "$COLUMN_PROTECTION = \"$str_protection\", " +
                    "$COLUMN_FEELINGS = \"$str_feelings\", " +
                    "$COLUMN_SYMPTOMS = \"$str_symptoms\", " +
                    "$COLUMN_LOG = \"$log\" " +
                    "WHERE $COLUMN_USER_ID = \"$UserID\" AND $COLUMN_EVENT_DATE = \"$oldEventDate\""
        val db = this.writableDatabase
        db.execSQL(updateQuery)
        db.close()
    }

    fun queryEventsByUserID(userID : Long) : ArrayList<Event> {
        val query =
            "SELECT * FROM $TABLE_EVENTS WHERE $COLUMN_USER_ID =  \"$userID\""

        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)

        var userEvents : ArrayList<Event> = arrayListOf()
        try {
            while (cursor.moveToNext()) {
                val event_date = Converter.dateStrToGregorianCalendar(cursor.getString(1))
                val event_list = Converter.DBStr2List(cursor.getString(2))
                val protection_list = Converter.DBStr2List(cursor.getString(3))
                val feelings_list = Converter.DBStr2List(cursor.getString(4))
                val symptoms_list = Converter.DBStr2List(cursor.getString(5))
                val log = cursor.getString(6)
                val e : Event = Event(event_date, event_list, protection_list, feelings_list, symptoms_list, log)
                userEvents.add(e)
            }
        } finally {
            cursor.close();
        }
        db.close()
        return userEvents
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
        val COLUMN_SEX = "sex_categories"
        val COLUMN_PROTECTION = "protection"
        val COLUMN_FEELINGS = "feelings"
        val COLUMN_SYMPTOMS = "symptoms"
        val COLUMN_LOG = "log"

    }
}