package com.example.sudoku

import com.example.sudoku.ui.puzzle.Cell
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object CellAsStringSerializer : KSerializer<Cell> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Cell", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Cell {
        val string = decoder.decodeString()
        val retrievedList =
            string.substring(2).split("/D".toRegex()).map { it.toInt() }.toMutableList()
        return Cell(retrievedList, string[0].digitToInt(), string[1].digitToInt())
    }

    override fun serialize(encoder: Encoder, value: Cell) {
        val string = value.x.toString() + value.y.toString() + value.data.toString()
        encoder.encodeString(string)
    }

}