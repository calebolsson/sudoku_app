package com.example.sudoku.ui.puzzle

class Board(difficulty: String, src: List<List<Int>>) {
    //var name: String? = name
    var difficulty: String? = difficulty
    var cellsSolved: Int = 0

    init {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                Companion.cells[i].add(Cell(mutableListOf(src[i][j]), i, j))
                if (Companion.cells[i][j].solved()) cellsSolved++
                // Uncomment the following line if needed:
                // println("[$i,$j] (${cells[i][j].answer()}) $cellsSolved/81")
            }
        }
    }

    fun isUnsolved(): Boolean {
        return cellsSolved < 81
    }

    companion object {
        var cells: MutableList<MutableList<Cell>> = MutableList(9) { mutableListOf() }
    }


}