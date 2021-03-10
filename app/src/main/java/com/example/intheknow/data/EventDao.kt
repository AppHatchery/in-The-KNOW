package com.example.intheknow.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/*
@Dao
interface EventDao {
    @Query("SELECT * FROM event_table")
    fun getTasks(): Flow<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: Event)

    @Update
    suspend fun update(event: Event)

    @Delete
    suspend fun delete(event: Event)
}
*/