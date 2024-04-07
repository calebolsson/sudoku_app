package com.example.sudoku

import com.example.sudoku.ui.puzzle.Cell
import kotlinx.serialization.Serializable

@Serializable
data class StoredData(
    val difficulty: Difficulty = Difficulty.Easy,
    var board: MutableList<MutableList<Cell>> = mutableListOf()
)

enum class Difficulty {
    Easy, Medium, Hard, Expert
}