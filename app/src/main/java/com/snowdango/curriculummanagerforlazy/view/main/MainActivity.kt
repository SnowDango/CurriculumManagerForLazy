package com.snowdango.curriculummanagerforlazy.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.snowdango.curriculummanagerforlazy.R
import com.snowdango.curriculummanagerforlazy.store.CurriculumStore

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

        setFrag()
    }

    private fun setFrag(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if(mCurriculumStore.curriculumData == null){
            val nullCurriculumFragment = NullCurriculumFragment()
            fragmentTransaction.replace(R.id.main_frame,nullCurriculumFragment)
        }else{
            val curriculumFragment = CurriculumFragment()
            fragmentTransaction.replace(R.id.main_frame,curriculumFragment)
        }
        fragmentTransaction.commit()
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