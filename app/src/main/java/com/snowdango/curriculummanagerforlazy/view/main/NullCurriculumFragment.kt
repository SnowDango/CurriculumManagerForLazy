package com.snowdango.curriculummanagerforlazy.view.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.snowdango.curriculummanagerforlazy.R

class NullCurriculumFragment: Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_null_curriculum,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addButton  = view.findViewById<ImageButton>(R.id.first_curriculum_add_button)
        addButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?){
        //TODO　時間割の追加処理を呼び出す
        Toast.makeText(activity,"click", Toast.LENGTH_SHORT).show()
    }
}