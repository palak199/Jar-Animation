package com.example.animatedlanding.data.datasrc

import android.content.Context
import com.example.animatedlanding.data.model.EducationData
import com.example.animatedlanding.data.model.EducationJsonResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Reader

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