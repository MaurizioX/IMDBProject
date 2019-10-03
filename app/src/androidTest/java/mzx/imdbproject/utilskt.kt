package mzx.imdbproject

import android.content.Context
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

inline fun <reified T> readResponse(context: Context, fileName: String): T =
    with(ObjectMapper().registerKotlinModule()) {
        val inputStream = context.assets.open(fileName)
        readValue(inputStream)
    }