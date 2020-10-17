package com.snowdango.curriculummanagerforlazy.store

enum class TimesMap(key: Int){
    START_H(0),
    START_M(1),
    END_H(2),
    END_M(3)
}

enum class WeekCycle(key: Int){
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6)
}

enum class Period(key: Int){
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4),
    SIXTH(5),
    SEVENTH(6)
}

data class CurriculumData(

    // 自動生成のPrimaryKey
    val id:Long?,
    // 時間割の名前
    val name:String?,
    // 時間割のコマ時間
    val times:ArrayList<Array<Int>>?,
    // 時間割りのコマの
    val curriculum: ArrayList<Array<String?>>?,
    // 欠席数
    val absents:ArrayList<Array<Int>>?,
    // 週何日か(5~7)
    val weekTimes: Int,
    // 1日の最高時限数
    val periodNum: Int

)

class CurriculumStore {

    public val curriculumData = CurriculumData(
        1,
        "test",
        arrayListOf(
            arrayOf(8,50,10,30),
            arrayOf(10,45,12,25),
            arrayOf(13,15,14,55),
            arrayOf(15,10,16,50),
            arrayOf(17,5,18,45),
            arrayOf(12,23,32,12)
        ),
        arrayListOf(
            arrayOf(null,null,null,"マーケティング","創成課題",null),
            arrayOf("キャリアデザインIV","コンピュータインタラクション",null,null,null,null),
            arrayOf(null,null,null,null,null,null),
            arrayOf("英語インテンシブIV",null,"サウンド情報処理",null,null,null),
            arrayOf(null,null,"プトジェクト実習U",null,null,null)
        ),
        arrayListOf(
            arrayOf(0,0,0,0,0,0),
            arrayOf(0,0,0,0,0,0),
            arrayOf(0,0,0,0,0,0),
            arrayOf(0,0,0,0,0,0),
            arrayOf(0,0,0,0,0,0),
        ),
        5,
        6
    )
}