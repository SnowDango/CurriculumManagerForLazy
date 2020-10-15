package com.snowdango.curriculummanagerforlazy.domain.models.dao.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromCurriculumData(curriculum: Map<String,Array<String?>>?):String? {
        if (curriculum == null) return null
        val type = object: TypeToken<Map<String,Array<String>>>(){}.type
        return Gson().toJson(curriculum,type)
    }

    @TypeConverter
    fun toCurriculumData(curriculumJsonString: String?): Map<String, Array<String>>? {
        if(curriculumJsonString == null) return null
        val type = object: TypeToken<Map<String,Array<String>>>(){}.type
        return Gson().fromJson<Map<String,Array<String>>>(curriculumJsonString,type)
    }

    @TypeConverter
    fun fromCurriculumTime(times: Map<Int,Map<String,String?>>):String? {
        val type = object: TypeToken<Map<Int,Map<String,String?>>>(){}.type
        return Gson().toJson(times,type)
    }

    @TypeConverter
    fun toCurriculumTime(curriculumTimeJsonString: String): Map<Int,Map<String,String?>>? {
        val type = object: TypeToken<Map<Int,Map<String,String?>>>(){}.type
        return Gson().fromJson<Map<Int,Map<String,String?>>>(curriculumTimeJsonString,type)
    }

    @TypeConverter
    fun fromCurriculumAbsent(curriculum: Map<String,Array<Int?>>?):String? {
        if (curriculum == null) return null
        val type = object: TypeToken<Map<String,Array<Int?>>>(){}.type
        return Gson().toJson(curriculum,type)
    }

    @TypeConverter
    fun toCurriculumAbsent(curriculumJsonString: String?): Map<String,Array<Int?>>? {
        if(curriculumJsonString == null) return null
        val type = object: TypeToken<Map<String,Array<Int?>>>(){}.type
        return Gson().fromJson<Map<String,Array<Int?>>>(curriculumJsonString,type)
    }

}