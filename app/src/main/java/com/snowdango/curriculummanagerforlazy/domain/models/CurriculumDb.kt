package com.snowdango.curriculummanagerforlazy.domain.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.snowdango.curriculummanagerforlazy.domain.models.dao.CurriculumDao
import com.snowdango.curriculummanagerforlazy.domain.models.dao.entity.Converter
import com.snowdango.curriculummanagerforlazy.domain.models.dao.entity.CurriculumData

@Database(entities = [CurriculumData::class],version = 1)
@TypeConverters(Converter::class)
abstract class CurriculumDb: RoomDatabase() {
    abstract fun curriculumDao(): CurriculumDao

    companion object{

        @Volatile private var INSTANCE: CurriculumDb? = null

        fun getDatabase(context: Context): CurriculumDb {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CurriculumDb::class.java, "curriculums.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}