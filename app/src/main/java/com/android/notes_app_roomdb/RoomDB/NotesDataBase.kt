package com.android.notes_app_roomdb.RoomDB

import android.R.attr.version
import android.content.Context
import android.provider.CalendarContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NotesDataBase::class], version=1, exportSchema = false)
abstract class NotesDataBase: RoomDatabase() {
    abstract fun getNotesDAO(): NotesDao

    companion object{
        @Volatile
        private var INSTANCE: NotesDataBase? = null

        fun getDataBase(context: Context): NotesDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDataBase::class.java,
                    "notedatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}