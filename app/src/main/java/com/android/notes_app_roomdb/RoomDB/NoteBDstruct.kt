package com.android.notes_app_roomdb.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
class NoteBDstruct(
    @ColumnInfo(name="title") val noteTitle: String,
    @ColumnInfo(name="description") val noteDescription: String,
    @ColumnInfo(name="timestamp") val timeStamp: String
) {
    @PrimaryKey(autoGenerate = true)
    val id = 0
}