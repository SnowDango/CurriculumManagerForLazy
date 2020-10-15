package com.snowdango.curriculummanagerforlazy.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.snowdango.curriculummanagerforlazy.R
import com.snowdango.curriculummanagerforlazy.store.CurriculumStore
import com.xwray.groupie.GroupAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mCurriculumStore = CurriculumStore()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings,menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.main_tool)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener(this)

        if(mCurriculumStore.curriculumData == null){
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.visibility = View.GONE
        }else{
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