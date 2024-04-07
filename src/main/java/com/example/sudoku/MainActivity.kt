package com.example.sudoku

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.datastore.dataStore
import androidx.navigation.compose.rememberNavController
import com.example.sudoku.ui.StoredDataSerializer
import com.example.sudoku.ui.main.NavigationGraph
import com.example.sudoku.ui.theme.SudokuTheme
import com.example.sudoku.ui.puzzle.Board

val Context.dataStore by dataStore("stored-data.json",StoredDataSerializer)

class MainActivity : ComponentActivity() {

    //var puzzle = Board();

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

    private suspend fun saveGame(currentBoard: Board) {
        dataStore.updateData { it.copy(
            board = Board.cells
        ) }
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
