package com.mondayjob.mondayjob.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mondayjob.mondayjob.R
import com.mondayjob.mondayjob.view.activity.JobDetailActivity
import com.mondayjob.mondayjob.view.adapter.FavJobAdapter
import com.mondayjob.mondayjob.view.adapter.JobsAdapter
import kotlinx.android.synthetic.main.fragment_fav.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class FavouriteFragment:Fragment() {
    internal var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView= inflater.inflate(R.layout.fragment_fav, container, false)
        initView()
        return  rootView;
    }

    private fun initView() {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>jobs adapter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        rootView?.rv_fav_jobs?.layoutManager= LinearLayoutManager(context)
        rootView?.rv_fav_jobs?.adapter= FavJobAdapter(activity)
        (rootView?.rv_fav_jobs?.adapter as FavJobAdapter).onItemClick = { pos, view ->


            val intent = Intent(context, JobDetailActivity::class.java)
            activity?.startActivity(intent)


        }
        rootView?.rv_fav_jobs?.setNestedScrollingEnabled(false)
    }
}