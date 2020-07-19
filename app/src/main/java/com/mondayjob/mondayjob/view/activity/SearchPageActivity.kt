package com.mondayjob.mondayjob.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.mondayjob.mondayjob.R
import kotlinx.android.synthetic.main.activity_search_page.*
import kotlinx.android.synthetic.main.custom_search_toolbar.*

class SearchPageActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_search_page)
        initView()
    }

    private fun initView() {
        nav_back.setOnClickListener(this)
        tv_advanced.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.nav_back ->
            {
                 onBackPressed()
            }
            R.id.tv_advanced ->
            {
                val intent = Intent(this, AdvancedSearchActivity::class.java)
                startActivity(intent)
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
