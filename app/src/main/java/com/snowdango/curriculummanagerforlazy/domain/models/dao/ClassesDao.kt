package com.snowdango.curriculummanagerforlazy.domain.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.snowdango.curriculummanagerforlazy.domain.models.dao.entity.Classes


@Dao
interface ClassesDao {

    @Query("SELECT uuid FROM classes")
    fun getUuid():Array<String>

    @Query("SELECT * FROM classes WHERE uuid=:uuid")
    fun getClass(uuid: String):Classes

    @Insert
    fun insert(classes: Classes)

    @Query("DELETE FROM classes WHERE uuid=:uuid")
    fun deleteAt(uuid: String)


}