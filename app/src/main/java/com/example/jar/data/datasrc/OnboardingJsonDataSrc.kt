package com.example.jar.data.datasrc

import android.content.Context
import com.example.jar.data.model.EducationJsonResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EducationJsonDataSrc(private val context: Context) {
     fun loadData(): EducationJsonResponse? {
        val gson = Gson()
        return try {
            val jsonData = context.assets.open("education_data.json")
                .bufferedReader().use { it.readText() }
            gson.fromJson(jsonData, object : TypeToken<EducationJsonResponse>() {}.type)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}