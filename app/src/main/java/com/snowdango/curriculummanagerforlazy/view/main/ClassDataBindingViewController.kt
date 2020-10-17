package com.snowdango.curriculummanagerforlazy.view.main

import android.view.View
import com.airbnb.epoxy.Typed2EpoxyController
import com.snowdango.curriculummanagerforlazy.classDataView
import com.snowdango.curriculummanagerforlazy.store.TimesMap

class ClassDataBindingViewController(
    private val selectListener: SelectListener
): Typed2EpoxyController<ArrayList<Array<String?>>, ArrayList<Array<Int>>>() {

    private val dayOfTheWeek: ArrayList<String> = arrayListOf("月曜日","火曜日","水曜日","木曜日","金曜日","土曜日","日曜日")

    interface SelectListener {
        fun onSelected(item: String)
    }

    override fun setSpanCount(spanCount: Int) {
        super.setSpanCount(spanCount)
    }

    override fun buildModels(schadule: ArrayList<Array<String?>>, times: ArrayList<Array<Int>>) {

        //最初の空
        classDataView {
            id("Content")
            className("")
        }

        times.forEach{
            classDataView {
                id("Content")
                className("${it[TimesMap.START_H.ordinal].toString()}:${it[TimesMap.START_M.ordinal].toString()} " +
                        "~ ${it[TimesMap.END_H.ordinal].toString()}:${it[TimesMap.END_M.ordinal].toString()}")
            }
        }

        for(num in 0 until schadule.size){
            classDataView {
                id("Content")
                className(dayOfTheWeek[num])
            }
            schadule[num].forEach {
                classDataView {
                    id("Content")
                    if(it == null){
                        className("null")
                    }else{
                        className(it)
                    }
                    onClickListener(View.OnClickListener { selectListener.onSelected(it.toString()) })
                }
            }
        }

    }
}