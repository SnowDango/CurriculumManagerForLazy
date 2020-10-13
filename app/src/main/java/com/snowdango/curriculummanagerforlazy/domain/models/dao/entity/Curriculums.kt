package com.snowdango.curriculummanagerforlazy.domain.models.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CurriculumTimes(
    val startTime: String,
    val endTime: String
)

data class WeekCurriculum(
    val monday: DayClasses,
    val tuesday: DayClasses,
    val wednesday: DayClasses,
    val thursday: DayClasses,
    val friday: DayClasses,
    val saturday: DayClasses,
    val sunday: DayClasses
){
    data class DayClasses(
        val className: String,
        val teacherName: String,
        val classRoom: String,
        var absence: Int
    )
}

@Entity(tableName = "curriculums")
data class Curriculums(

    // 自動生成のPrimaryKey
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    // 時間割の名前
    @ColumnInfo(name = "curriculum-name")
    val curriculumName:String,
    // 時間割のコマ時間
    @ColumnInfo(name = "curriculum-time")
    val curriculumTimes: ArrayList<CurriculumTimes>,
    // 時間割りのコマの
    @ColumnInfo(name = "classes")
    val classes: WeekCurriculum,
    // 週何日か(5~7)
    @ColumnInfo(name = "week-times")
    val weekTimes: Int
)