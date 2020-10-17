package com.snowdango.curriculummanagerforlazy.domain.models.dao

import androidx.room.*
import com.snowdango.curriculummanagerforlazy.domain.models.dao.entity.CurriculumData

@Dao
interface CurriculumDao {

    //id一覧の取得
    @Query("SELECT id FROM curriculum")
    fun getIdList():List<Long>

    //curriculumの取得
    @Query("SELECT * FROM curriculum WHERE id=:id")
    fun getCurriculum(id:Long): CurriculumData

    // 追加
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(curriculumData: CurriculumData):Long

    //idでdelete
    @Query("DELETE FROM curriculum WHERE id=:id")
    fun deleteAt(id: Long)

    // Scheduleのupdate
    @Query("UPDATE curriculum SET `schedule-uuid`=:schedule WHERE id=:id ")
    fun updateSchedule(id:Long,schedule:Map<String,Array<String?>>)

    @Query("UPDATE curriculum SET `curriculum-times`=:curriculumTimes WHERE id=:id")
    fun updateCurriculumTimes(id:Long,curriculumTimes:Map<Int,Map<String,String?>>)



}