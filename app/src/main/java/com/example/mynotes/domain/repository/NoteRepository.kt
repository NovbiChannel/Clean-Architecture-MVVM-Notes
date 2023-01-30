package com.example.mynotes.domain.repository

import com.example.mynotes.data.local.dao.NoteRepositoryImpl
import com.example.mynotes.domain.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteRepositoryImpl: NoteRepositoryImpl) {

    suspend fun getAllNote(): List<Note> = noteRepositoryImpl.getAllNotes()
    suspend fun insertNote(note: Note) = noteRepositoryImpl.insertNote(note = note)
    suspend fun deleteNote(note: Note) = noteRepositoryImpl.deleteNote(note = note)
    suspend fun getNoteById(id: Long) = noteRepositoryImpl.getNoteById(noteId = id)

}