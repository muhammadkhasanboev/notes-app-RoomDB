package com.android.notes_app_roomdb.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteBDstruct)

    @Delete
    suspend fun delete(note: NoteBDstruct)

    //notesTable - name of the entity
    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<NoteBDstruct>>

    @Update
    suspend fun update(note: NoteBDstruct)
}