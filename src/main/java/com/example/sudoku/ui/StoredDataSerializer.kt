package com.example.sudoku.ui

import androidx.datastore.core.Serializer
import com.example.sudoku.StoredData
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

@Suppress("BlockingMethodInNonBlockingContext")
object StoredDataSerializer : Serializer<StoredData> {
    override val defaultValue: StoredData
        get() = StoredData()

    override suspend fun readFrom(input: InputStream): StoredData {
        return try {
            Json.decodeFromString(
                deserializer = StoredData.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: StoredData, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = StoredData.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }

}