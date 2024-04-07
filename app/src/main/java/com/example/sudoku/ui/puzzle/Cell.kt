package com.example.sudoku.ui.puzzle

import com.example.sudoku.CellAsStringSerializer
import kotlinx.serialization.Serializable

@Serializable(with = CellAsStringSerializer::class)
class Cell(num: MutableList<Int>, val xCoordinate: Int, val yCoordinate: Int) {
    val x = xCoordinate
    val y = yCoordinate
    var data: MutableList<Int> = if (num[0] != 0) num else (1..9).toMutableList()

    fun isSame(obj: Cell): Boolean {
        return this.x == obj.x && this.y == obj.y
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cell) return false
        if (data.size != other.data.size) return false
        for (i in data.indices) {
            if (data[i] != other.data[i]) return false
        }
        return true
    }

    override fun hashCode(): Int {
        return debugData().toIntOrNull() ?: 0
    }

    fun debugData(): String {
        val stringBuilder = StringBuilder()
        data.forEach { note ->
            stringBuilder.append((48 + note).toChar())
        }
        return stringBuilder.toString()
    }

    fun answer(): Int {
        return if (solved()) data[0] else 0
    }

    fun remove(cells: List<Cell>) {
        cells.forEach { cell ->
            cell.data.forEach { value ->
                this.data.remove(value)
            }
        }
    }

    fun solved(): Boolean {
        return data.size == 1
    }
}