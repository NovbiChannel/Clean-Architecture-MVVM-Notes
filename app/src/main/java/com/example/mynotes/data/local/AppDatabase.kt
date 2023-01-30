package com.example.mynotes.data.local

import androidx.room.Database
import com.example.mynotes.data.local.dao.NoteRepositoryImpl
import com.example.mynotes.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase {
    abstract fun noteDao(): NoteRepositoryImpl
}