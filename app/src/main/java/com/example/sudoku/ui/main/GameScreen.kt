package com.example.sudoku.ui.main

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sudoku.MainActivity.Path
import com.example.sudoku.ui.theme.SudokuTheme

enum class InputMode() {
    SetNumber,
    NotesEditor
}

@Composable
fun GameScreen(navController: NavController) {
    GameScreenContent(
        onClickHome = { navController.navigate(Path.HomeScreen.string) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreenContent(onClickHome: () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            "Centered Top App Bar",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onClickHome) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                )
                SudokuBoard()
                InputInterface(InputMode.SetNumber)
            }
        }
    }
}

@Composable
fun SudokuBoard() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .aspectRatio(1f)
            .border(width = 2.dp, color = Color.Black),
    )
    {
        val boxHeight = maxHeight / 3
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in 0 until 3) {
                Row(
                    modifier = Modifier.height(boxHeight)
                ) {
                    for (j in 0 until 3) {
                        SudokuBox()
                    }
                }
            }
        }
    }
}

@Composable
fun SudokuBox() {
    BoxWithConstraints(
        modifier = Modifier
            .aspectRatio(1f)
            .border(width = 1.dp, color = Color.Black)
    ) {
        val boxHeight = maxHeight / 3
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in 0 until 3) {
                Row(
                    modifier = Modifier.height(boxHeight)
                ) {
                    for (j in 0 until 3) {
                        SudokuCell()
                    }
                }
            }
        }
    }
}

@Composable
fun SudokuCell() {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .border(width = 0.5.dp, color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "0",
            style = TextStyle(textAlign = TextAlign.Center, fontSize = 25.sp),
            modifier = Modifier
        )
    }
}

@Composable
fun InputInterface(mode: InputMode) {
    if (mode == InputMode.SetNumber) {
        Box(modifier = Modifier) {
            NumberPalette()
        }
    } else if (mode == InputMode.NotesEditor) {
        Box(modifier = Modifier) {
            SudokuBox()
        }
    }
}

@Composable
fun NumberPalette() {
    Row(
        modifier = Modifier.padding(20.dp)
    ) {
        for (x in 1 until 10)
            Text(text = x.toString(), Modifier.padding(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    SudokuTheme {
        GameScreenContent({})
    }
}