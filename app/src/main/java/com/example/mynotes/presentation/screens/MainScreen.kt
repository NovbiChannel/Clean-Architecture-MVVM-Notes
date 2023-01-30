package com.example.mynotes.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mynotes.presentation.ui.components.NoteItem
import com.example.mynotes.presentation.ui.theme.Black
import com.example.mynotes.presentation.ui.theme.MyNotesTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val viewModel = hiltViewModel<MainViewModel>()
    val notes = viewModel.notes.observeAsState(listOf()).value
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Add, tint = Color.White, contentDescription = "add")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Мои заметки",
                fontSize = 24.sp,
                color = Black,
                modifier = Modifier
                    .padding(top = 18.dp, start = 8.dp, bottom = 18.dp)
                )

            notes.forEach { note ->
                NoteItem(
                    title = note.title,
                    content = note.content,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .padding(horizontal = 8.dp)
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun previewMainScreen() {
    MyNotesTheme {
        MainScreen()
    }
}