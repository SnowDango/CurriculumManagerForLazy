package com.snowdango.curriculummanagerforlazy.view.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.snowdango.curriculummanagerforlazy.R
import com.snowdango.curriculummanagerforlazy.store.CurriculumStore


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mCurriculumStore = CurriculumStore()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.main_tool)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(this)

        if(mCurriculumStore.curriculumData == null){
            val recyclerView: EpoxyRecyclerView = findViewById(R.id.recyclerView)
            recyclerView.visibility = View.GONE
        }else{

            val classDataBindingViewController = ClassDataBindingViewController(object :
                ClassDataBindingViewController.SelectListener {
                override fun onSelected(item: String) {
                    Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
                }
            })

            classDataBindingViewController.spanCount = mCurriculumStore.curriculumData.periodNum+1

            val recyclerView: EpoxyRecyclerView = findViewById(R.id.recyclerView)
            recyclerView.apply {
                addItemDecoration(DividerItemDecoration(recyclerView.context,DividerItemDecoration.HORIZONTAL))
                addItemDecoration(DividerItemDecoration(recyclerView.context,DividerItemDecoration.VERTICAL))
                adapter = classDataBindingViewController.adapter
                layoutManager = CannotScrollGridLayoutManager(
                    applicationContext,
                    mCurriculumStore.curriculumData.periodNum + 1
                ).apply {
                    orientation = GridLayoutManager.HORIZONTAL
                    spanSizeLookup = classDataBindingViewController.spanSizeLookup
                }

                viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        viewTreeObserver.removeOnGlobalLayoutListener(this)
                        val xChildNum = mCurriculumStore.curriculumData.weekTimes + 1
                        val yChildNum = mCurriculumStore.curriculumData.periodNum + 1
                        val xMax = recyclerView.width
                        for (num in 0 until xChildNum*yChildNum ){
                            val lp = recyclerView[num].layoutParams
                            lp.width = xMax/xChildNum
                            recyclerView.getChildAt(num).layoutParams = lp
                        }
                    }
                })
            }

            classDataBindingViewController.setData(
                mCurriculumStore.curriculumData.curriculum,
                mCurriculumStore.curriculumData.times
            )
            val linearLayout: LinearLayout = findViewById(R.id.null_linear)
            linearLayout.visibility = View.GONE
        }

    }

    override fun onClick(p0: View?) {
        val navigationId:Int = -1
        when(p0?.id){
            navigationId -> Toast.makeText(this, "navigation click", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.tool_settings -> Toast.makeText(this, "settings click", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}
