package com.android.notes_app_roomdb.RoomDB

import android.provider.ContactsContract
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
    suspend fun insert(note: ContactsContract.CommonDataKinds.Note)

    @Delete
    suspend fun delete(note: ContactsContract.CommonDataKinds.Note)

    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<ContactsContract.CommonDataKinds.Note>>

    @Update
    suspend fun update(note: ContactsContract.CommonDataKinds.Note)
}