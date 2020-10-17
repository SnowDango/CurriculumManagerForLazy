package com.snowdango.curriculummanagerforlazy.domain.models.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classes")
data class Classes(
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    val uuid:String,

    @ColumnInfo(name = "class-name")
    val className:String,

    @ColumnInfo(name = "class-color")
    val classColor: String?,

    @ColumnInfo(name = "class-room")
    val classRoom: String?,

    @ColumnInfo(name = "class-teacher")
    val classTeacher: String?,

)