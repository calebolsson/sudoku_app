package com.example.sudoku.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sudoku.MainActivity.Path

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Path.HomeScreen.string) {
        composable(Path.HomeScreen.string) { HomeScreen(navController) }
        composable(Path.ImportScreen.string) { ImportImage(navController) }
        composable(Path.GameScreen.string) { GameScreen(navController) }
        // Add more destinations similarly.
    }
}
