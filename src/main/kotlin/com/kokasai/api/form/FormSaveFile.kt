package com.kokasai.api.form

import com.kokasai.api.util.json.JsonFile
import com.kokasai.api.util.serialize.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date

@Serializable
data class FormSaveFile(
    @Serializable(with = DateSerializer::class) var update: Date = Date(),
    var values: Map<Int, FormSaveValue> = mapOf(),
    val comment: String = "",
    var status: Int = 0
) : JsonFile() {
    override fun toJson() = Json.encodeToString(this)

    companion object : JsonFile.Companion<FormSaveFile> {
        override fun from(json: String): FormSaveFile? = Json.decodeFromString(json)

        override fun empty() = FormSaveFile()
    }
}

@Serializable
data class FormSaveValue(
    val value: FormSaveType,
    val comment: String
)

@Serializable
sealed class FormSaveType {
    @Serializable
    @SerialName("string")
    data class String(val content: kotlin.String) : FormSaveType()

    @Serializable
    @SerialName("check")
    data class Check(val select: List<Int>) : FormSaveType()
}
