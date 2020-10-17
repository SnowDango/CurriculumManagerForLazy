package com.snowdango.curriculummanagerforlazy.view.main

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager

class CannotScrollGridLayoutManager(
    context: Context?,
    spanCount: Int
) : GridLayoutManager(context, spanCount) {

    override fun canScrollVertically(): Boolean {
        return false
    }

    override fun canScrollHorizontally(): Boolean {
        return false
    }
}
