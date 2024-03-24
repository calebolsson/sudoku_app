package com.example.sudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.sudoku.ui.main.NavigationGraph
import com.example.sudoku.ui.theme.SudokuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SudokuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph(navController)
                }
            }
        }
    }

    enum class Path(val string: String) {
        HomeScreen("home_screen"),
        GameScreen("game_screen"),
        ImportScreen("import_screen"),
        CustomizationsScreen("customizations_screen"),
        SettingsScreen("settings_screen")
    }

    //val PICK_IMAGE_REQUEST = 1

//    fun haveStoragePermission() =
//        ContextCompat.checkSelfPermission(
//            this,
//            Manifest.permission.
//        ) == PERMISSION_GRANTED




}
