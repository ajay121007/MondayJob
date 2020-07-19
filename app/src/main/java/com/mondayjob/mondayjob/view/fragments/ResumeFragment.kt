package com.mondayjob.mondayjob.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mondayjob.mondayjob.R
import kotlinx.android.synthetic.main.fragment_resume.view.*

class ResumeFragment:Fragment() {
    internal var rootView: View? = null
    private var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView= inflater.inflate(R.layout.fragment_resume, container, false)
        initView()
        return  rootView;
    }

    private fun initView() {
        viewPager = rootView?.findViewById(R.id.viewpager) as ViewPager
        setupViewPager(viewPager!!)

        tabLayout = rootView?.findViewById(R.id.tabs) as TabLayout
        tabLayout!!.setupWithViewPager(viewPager)

    }

    //..................................setup view pager.............................................//

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(ResumeLetterFragment(), "Resume")
        adapter.addFragment(CoverLetterFragment(), "Cover Letter")
        viewPager.adapter = adapter
    }
    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }
}