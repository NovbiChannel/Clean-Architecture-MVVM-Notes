package com.example.mynotes.presentation.screens.details

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynotes.presentation.ui.theme.MyNotesTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mynotes.domain.model.Note
import com.example.mynotes.presentation.navigation.Screens
import com.example.mynotes.presentation.screens.add.AddViewModel
import com.example.mynotes.presentation.ui.theme.backgroundColor


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
    navController: NavController,
    id: String?
) {
    val viewModel = hiltViewModel<AddViewModel>()
    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .shadow(elevation = 15.dp)
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clickable { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "nav back",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }

                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clickable {
//                            viewModel.addNote(
//                                Note(
//                                    title = title,
//                                    content = description
//                                )
//                            ) {
//                                navController.navigate(Screens.MainScreen.rout)
//                            }
                        }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Delete,
                        contentDescription = "delete note",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 16.dp)
        ) {
            Text(text = "ssadasdasdasd")
            Text(text = "ssadasdasdasdasdasdasdasdasd")
        }
    }
}