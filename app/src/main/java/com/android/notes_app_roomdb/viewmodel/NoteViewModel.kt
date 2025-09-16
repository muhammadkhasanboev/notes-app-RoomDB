package com.android.notes_app_roomdb.viewmodel

import com.android.notes_app_roomdb.model.NoteRepository


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.android.notes_app_roomdb.RoomDB.NoteBDstruct
import com.android.notes_app_roomdb.RoomDB.NotesDataBase

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes: LiveData<List<NoteBDstruct>>
    private val repository: NoteRepository

    init {
        val dao = NotesDataBase.getDataBase(application).getNotesDAO()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(note: NoteBDstruct) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    fun updateNote(note: NoteBDstruct) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }

    fun addNote(note: NoteBDstruct) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}