package com.example.mynotes.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mynotes.presentation.navigation.Screens
import com.example.mynotes.presentation.ui.components.NoteItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    val viewModel = hiltViewModel<MainViewModel>()
    val notes = viewModel.notes.observeAsState(listOf()).value
    Scaffold (
        topBar = {
                 Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .shadow(elevation = 15.dp)
                .background(MaterialTheme.colors.primary)
            ) {
                     Text(
                         text = "Мои заметки",
                         fontSize = 24.sp,
                         color = MaterialTheme.colors.primaryVariant,
                         modifier = Modifier
                             .padding(start = 8.dp)
                     )
                 }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screens.AddScreen.rout) }) {
                Icon(imageVector = Icons.Filled.Add, tint = Color.White, contentDescription = "add")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 4.dp)
        ) {

            notes.forEach { note ->
                NoteItem(
                    title = note.title,
                    content = note.content,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 45.dp)
                        .padding(vertical = 8.dp)
                        .padding(horizontal = 8.dp)
                        .clickable {
                            navController.navigate(Screens.DetailScreen.rout + "/${note.id}")
                        }
                )
            }

        }
    }
}