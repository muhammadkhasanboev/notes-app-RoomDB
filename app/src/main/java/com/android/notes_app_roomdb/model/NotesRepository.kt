package com.android.notes_app_roomdb.model
import com.android.notes_app_roomdb.RoomDB.NotesDao
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.android.notes_app_roomdb.RoomDB.NoteBDstruct
import java.util.concurrent.Flow

class NoteRepository(private val notesDao: NotesDao) {

    // on below line we are creating a variable for our list
    // and we are getting all the notes from our DAO class.
    val allNotes: LiveData<List<NoteBDstruct>> = notesDao.getAllNotes()

    // on below line we are creating an insert method
    // for adding the note to our database.
    suspend fun insert(note: NoteBDstruct) {
        notesDao.insert(note)
    }

    // on below line we are creating a delete method
    // for deleting our note from database.
    suspend fun delete(note: NoteBDstruct){
        notesDao.delete(note)
    }

    // on below line we are creating a update method for
    // updating our note from database.
    suspend fun update(note: NoteBDstruct){
        notesDao.update(note)
    }
}