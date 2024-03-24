package com.example.sudoku.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sudoku.MainActivity.Path
import com.example.sudoku.ui.theme.SudokuTheme

@Composable
fun HomeScreen(navController: NavController) {
    HomeScreenContent(
        onClickImport = { navController.navigate(Path.ImportScreen.string) },
        onClickContinue = { navController.navigate(Path.GameScreen.string) }
    )
}

@Composable
fun HomeScreenContent(onClickContinue: () -> Unit, onClickImport: () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "SUDOKU",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(100.dp)
                )
                Button(
                    //enabled = puzzle != "Sudoku",
                    onClick = onClickContinue,
                    modifier = Modifier
                        .padding(5.dp)
                        .width(150.dp)
                ) {
                    Text(
                        text = "Continue Game"
                    )
                }
                Button(
                    onClick = onClickImport,
                    modifier = Modifier
                        .padding(5.dp)
                        .width(150.dp)
                ) {
                    Text(text = "Import Puzzle")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(150.dp)
                ) {
                    Text(text = "Customization")
                }
                Row(modifier = Modifier.padding(50.dp)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "Dev"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Warning,
                            contentDescription = "Dev"
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SudokuTheme {
        HomeScreenContent({}, {})
    }
}