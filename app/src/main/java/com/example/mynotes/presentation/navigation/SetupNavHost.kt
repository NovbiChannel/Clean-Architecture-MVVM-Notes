package com.example.mynotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mynotes.presentation.screens.add.AddScreen
import com.example.mynotes.presentation.screens.details.DetailsScreen
import com.example.mynotes.presentation.screens.main.MainScreen

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
            MainScreen(navController = navController)
        }
        composable(route = Screens.DetailScreen.rout + "/{id}",
            arguments = listOf(navArgument("id") {type = NavType.StringType})) {
            DetailsScreen(navController = navController, it.arguments?.getString("id"))
        }
        composable(route = Screens.AddScreen.rout) {
            AddScreen(navController = navController)
        }
    }
}