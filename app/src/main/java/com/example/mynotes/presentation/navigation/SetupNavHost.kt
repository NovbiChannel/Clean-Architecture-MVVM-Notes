package com.example.mynotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mynotes.presentation.screens.MainScreen

sealed class Screens(val rout: String) {
    object MainScreen: Screens(rout = "main_screen")
    object DetailScreen: Screens(rout = "detail_screen")
    object AddScreen: Screens(rout = "add_screen")
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.rout
    ) {
        composable(route = Screens.MainScreen.rout) {
            MainScreen()
        }
        composable(route = Screens.DetailScreen.rout) {

        }
        composable(route = Screens.AddScreen.rout) {

        }
    }
}