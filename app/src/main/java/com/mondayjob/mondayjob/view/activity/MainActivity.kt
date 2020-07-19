package com.mondayjob.mondayjob.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mondayjob.mondayjob.R
import com.mondayjob.mondayjob.view.adapter.HomeVPAdapter
import com.mondayjob.mondayjob.view.fragments.FavouriteFragment
import com.mondayjob.mondayjob.view.fragments.HistoryFragment
import com.mondayjob.mondayjob.view.fragments.HomeFragment
import com.mondayjob.mondayjob.view.fragments.ResumeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_navigation_bar_user.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), DrawerLayout.DrawerListener,View.OnClickListener {
    private var adapterViewPager: HomeVPAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        initView()
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>setting bottom navigation using view pager>>>>>>.>>>>>>>>>>>>
    private fun initView() {
        tv_title.setText(getString(R.string.home))

        nav_menu.setOnClickListener(this)
        ll_profile.setOnClickListener(this)
        ll_contact_us.setOnClickListener(this)
        ll_logout.setOnClickListener(this)
        ll_lan.setOnClickListener(this)
        ll_serach_view.setOnClickListener(this)

        val menuView =
            bottom_navigation.getChildAt(0) as BottomNavigationMenuView

        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView
            val activeLabel =
                item.findViewById<View>(R.id.largeLabel)
            (activeLabel as? TextView)?.setPadding(0, 0, 0, 0)
        }


        val flList: MutableList<FrameLayout> = ArrayList()
        flList.add(fl_home)
        flList.add(fl_fav)
        flList.add(fl_history)
        flList.add(fl_resume)

        val fragList: MutableList<Fragment> =
            ArrayList()
        fragList.add(HomeFragment())
        fragList.add(FavouriteFragment())
        fragList.add(HistoryFragment())
        fragList.add(ResumeFragment())


        adapterViewPager = HomeVPAdapter(supportFragmentManager, flList, fragList)
        vp_main.setOffscreenPageLimit(4)
        vp_main.setAdapter(adapterViewPager)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>bottom navigation menu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val menuNav: Menu = bottom_navigation.getMenu()
            val menuItem = menuNav.findItem(R.id.nav_home)
            when (item.itemId) {
                R.id.nav_home -> {
                    tv_title.setText(getString(R.string.home))
                    vp_main.setCurrentItem(0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_fav -> {
                    tv_title.setText(getString(R.string.favouritejob))
                    vp_main.setCurrentItem(1)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_history -> {
                    tv_title.setText(getString(R.string.jobapplication))
                    vp_main.setCurrentItem(2)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_resume-> {
                    tv_title.setText("Resume & Cover letter")
                    vp_main.setCurrentItem(3)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>side bar menu>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    override fun onDrawerStateChanged(newState: Int) {

    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

    }
    override fun onDrawerClosed(drawerView: View) {

    }

    override fun onDrawerOpened(drawerView: View) {

    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.nav button click to open the drawer>>>>>>>>>>>>>>>>>>>>>>>>
    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.nav_menu ->
            {
                drawer_layout.openDrawer(Gravity.START)
            }
            R.id.ll_logout ->
            {

                finishAffinity()
            }
            R.id.ll_profile ->
            {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.ll_contact_us ->
            {
                val intent = Intent(this, Contact_Us_Activity::class.java)
                startActivity(intent)
            }
            R.id.ll_lan ->
            {
                val intent = Intent(this, LanguageActivity::class.java)
                startActivity(intent)
            }
            R.id.ll_serach_view ->
            {
                val intent = Intent(this, SearchPageActivity::class.java)
                startActivity(intent)
            }
        }

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
