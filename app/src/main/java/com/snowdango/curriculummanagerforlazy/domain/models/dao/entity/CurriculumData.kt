package com.snowdango.curriculummanagerforlazy.domain.models.dao.entity

import androidx.room.*

enum class TimesMap(val key:String){
    START_HOUR("startH"),
    START_MINUTES("startM"),
    END_HOUR("endH"),
    END_MINUTES("endM")
}

enum class WeekDay(val key:String){
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday")
}

@Entity(tableName = "curriculum")
data class CurriculumData(

    // 自動生成のPrimaryKey
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Long?,
    // 時間割の名前
    @ColumnInfo(name = "name")
    val name:String?,
    // 時間割のコマ時間
    @ColumnInfo(name = "curriculum-times")
    val times: Map<Int,Map<String,String?>> = mapOf(
        1 to mapOf(TimesMap.START_HOUR.key to null,TimesMap.START_MINUTES.key to null,
            TimesMap.END_HOUR.key to null,TimesMap.END_MINUTES.key to null),
        2 to mapOf(TimesMap.START_HOUR.key to null,TimesMap.START_MINUTES.key to null,
            TimesMap.END_HOUR.key to null,TimesMap.END_MINUTES.key to null),
        3 to mapOf(TimesMap.START_HOUR.key to null,TimesMap.START_MINUTES.key to null,
            TimesMap.END_HOUR.key to null,TimesMap.END_MINUTES.key to null),
        4 to mapOf(TimesMap.START_HOUR.key to null,TimesMap.START_MINUTES.key to null,
            TimesMap.END_HOUR.key to null,TimesMap.END_MINUTES.key to null),
        5 to mapOf(TimesMap.START_HOUR.key to null,TimesMap.START_MINUTES.key to null,
            TimesMap.END_HOUR.key to null,TimesMap.END_MINUTES.key to null),
        6 to mapOf(TimesMap.START_HOUR.key to null,TimesMap.START_MINUTES.key to null,
            TimesMap.END_HOUR.key to null,TimesMap.END_MINUTES.key to null),
        7 to mapOf(TimesMap.START_HOUR.key to null,TimesMap.START_MINUTES.key to null,
            TimesMap.END_HOUR.key to null,TimesMap.END_MINUTES.key to null)
    ),
    // 時間割りのコマの
    @ColumnInfo(name = "schedule-uuid")
    val curriculum: Map<String,Array<String?>> = mapOf(
        WeekDay.MONDAY.key to arrayOfNulls(7),
        WeekDay.TUESDAY.key to arrayOfNulls(7),
        WeekDay.WEDNESDAY.key to arrayOfNulls(7),
        WeekDay.THURSDAY.key to arrayOfNulls(7),
        WeekDay.FRIDAY.key to arrayOfNulls(7),
        WeekDay.SATURDAY.key to arrayOfNulls(7),
        WeekDay.SUNDAY.key to arrayOfNulls(7)
    ),

    // 欠席数
    @ColumnInfo(name = "absents")
    val absents: Map<String,Array<Int?>> = mapOf(
        WeekDay.MONDAY.key to arrayOfNulls(7),
        WeekDay.TUESDAY.key to arrayOfNulls(7),
        WeekDay.WEDNESDAY.key to arrayOfNulls(7),
        WeekDay.THURSDAY.key to arrayOfNulls(7),
        WeekDay.FRIDAY.key to arrayOfNulls(7),
        WeekDay.SATURDAY.key to arrayOfNulls(7),
        WeekDay.SUNDAY.key to arrayOfNulls(7)
    ),

    // 週何日か(5~7)
    @ColumnInfo(name = "week-times")
    val weekTimes: Int

)