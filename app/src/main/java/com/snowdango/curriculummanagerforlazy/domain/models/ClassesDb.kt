package com.snowdango.curriculummanagerforlazy.domain.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.snowdango.curriculummanagerforlazy.domain.models.dao.ClassesDao
import com.snowdango.curriculummanagerforlazy.domain.models.dao.entity.Classes


@Database(entities = [Classes::class],version = 1)
abstract class ClassesDb:RoomDatabase() {

    abstract fun classesDao(): ClassesDao

    companion object{

        @Volatile private var INSTANCE: ClassesDb? = null

        fun getDatabase(context: Context): ClassesDb {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ClassesDb::class.java, "classes.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}