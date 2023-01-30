package com.example.mynotes.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.domain.model.Note
import com.example.mynotes.domain.usecases.GetAllNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNoteUseCase
): ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>>
        get() = _notes

    init {
        getAllNotes()
    }

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.invoke().let {
                _notes.postValue(it)
            }
        }
    }
}