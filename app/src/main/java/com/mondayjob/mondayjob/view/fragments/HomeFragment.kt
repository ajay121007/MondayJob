package com.mondayjob.mondayjob.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mondayjob.mondayjob.R
import com.mondayjob.mondayjob.view.activity.JobDetailActivity
import com.mondayjob.mondayjob.view.adapter.BrowseCategoryAdapter
import com.mondayjob.mondayjob.view.adapter.HotCompaniesAdapter
import com.mondayjob.mondayjob.view.adapter.JobsAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment :Fragment() {
    internal var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView= inflater.inflate(R.layout.fragment_home, container, false)
        initView()
        return  rootView;
    }
    private fun initView() {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Hot Companies>>>>>>>>>>>>>>>>>>>>>>>>>>
        rootView?.rv_hot_companies?.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL ,false)
        rootView?.rv_hot_companies?.adapter= HotCompaniesAdapter(activity)

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Browse By Category Adapter>>>>>>>>>>>>>>>>>>>>>>>>>>
        rootView?.rv_browse_categories?.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL ,false)
        rootView?.rv_browse_categories?.adapter= BrowseCategoryAdapter(activity)

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>jobs adapter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        rootView?.rv_recommended_jobs?.layoutManager= LinearLayoutManager(context)
        rootView?.rv_recommended_jobs?.adapter= JobsAdapter(activity)
        (rootView?.rv_recommended_jobs?.adapter as JobsAdapter).onItemClick = { pos, view ->
            val intent = Intent(context, JobDetailActivity::class.java)
            activity?.startActivity(intent)


        }
        rootView?.rv_recommended_jobs?.setNestedScrollingEnabled(false)

    }

}