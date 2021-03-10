package com.example.intheknow.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues

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
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int,
                           newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS)
        onCreate(db)
    }

    fun addUser(user: User) {

        val values = ContentValues()
        values.put(COLUMN_USERNAME, user.username)
        values.put(COLUMN_PASSWORD, user.password)
        values.put(COLUMN_GENDER, user.gender)
        values.put(COLUMN_SEXUALITY, user.sexuality)
        values.put(COLUMN_DOB, user.DOB)
        values.put(COLUMN_FIRSTNAME, user.firstName)
        values.put(COLUMN_LASTNAME, user.lastName)

        val db = this.writableDatabase

        db.insert(TABLE_USERS, null, values)
        db.close()
    }

    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "itkDB.db"

        val TABLE_USERS = "users"
        val COLUMN_ID = "_id"
        val COLUMN_USERNAME = "username"
        val COLUMN_PASSWORD = "password"
        val COLUMN_GENDER = "gender"
        val COLUMN_SEXUALITY = "sexuality"
        val COLUMN_DOB = "dob"
        val COLUMN_FIRSTNAME = "firstname"
        val COLUMN_LASTNAME = "lastname"
    }
}