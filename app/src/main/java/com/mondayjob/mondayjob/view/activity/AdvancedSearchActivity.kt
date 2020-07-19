package com.mondayjob.mondayjob.view.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import com.mondayjob.mondayjob.R
import kotlinx.android.synthetic.main.activity_advanced_search.*
import kotlinx.android.synthetic.main.custom_toolbar_detail_page.*

class AdvancedSearchActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_advanced_search)
        initView()
    }

    private fun initView() {
        sp_function!!.setOnItemSelectedListener(this)
        sp_industary!!.setOnItemSelectedListener(this)
        sp_employ_nature!!.setOnItemSelectedListener(this)
        sp_salary_type!!.setOnItemSelectedListener(this)
        nav_back.setOnClickListener(this)
        tv_search.setOnClickListener(this)

        val function = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.function))
        function.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_function!!.setAdapter(function)

        val industry = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.industry))
        industry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_industary!!.setAdapter(industry)

        val nature = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.nature))
        nature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_employ_nature!!.setAdapter(nature)

        val salary = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.salrytype))
        salary.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_salary_type!!.setAdapter(salary)

    }

    //>.......................................spinner...........................................................
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.nav_back->
            {
                onBackPressed()
            }
            R.id.tv_search->
            {
                var toast = Toast.makeText(this, "under development", Toast.LENGTH_LONG)
                toast.show()
            }
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    //................................hide keyboard on touch.................................................
    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager =
            activity.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus!!.windowToken, 0
        )
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val view = currentFocus
        val ret = super.dispatchTouchEvent(ev)
        if (view is EditText) {
            val w = currentFocus
            val scrcoords = IntArray(2)
            w!!.getLocationOnScreen(scrcoords)
            val x = ev.rawX + w.left - scrcoords[0]
            val y = ev.rawY + w.top - scrcoords[1]
            if (ev.action == MotionEvent.ACTION_UP
                && (x < w.left || x >= w.right || y < w.top || y > w.bottom)
            ) {
                hideSoftKeyboard(this)
            }
        }
        return ret
    }
}
