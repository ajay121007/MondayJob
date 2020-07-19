package com.mondayjob.mondayjob.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mondayjob.mondayjob.R
import com.mondayjob.mondayjob.view.activity.HistoryJobDetailActivity
import com.mondayjob.mondayjob.view.activity.JobDetailActivity
import com.mondayjob.mondayjob.view.adapter.FavJobAdapter
import com.mondayjob.mondayjob.view.adapter.JobsHistoryAdapter
import kotlinx.android.synthetic.main.fragment_fav.view.*
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment:Fragment() {
    internal var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView= inflater.inflate(R.layout.fragment_history, container, false)
        initview()
        return  rootView;
    }

    private fun initview() {
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>jobs history adapter>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        rootView?.rv_jobs_history?.layoutManager= LinearLayoutManager(context)
        rootView?.rv_jobs_history?.adapter= JobsHistoryAdapter(activity)
        (rootView?.rv_jobs_history?.adapter as JobsHistoryAdapter).onItemClick = { pos, view ->


            val intent = Intent(context, HistoryJobDetailActivity::class.java)
            activity?.startActivity(intent)


        }
        rootView?.rv_fav_jobs?.setNestedScrollingEnabled(false)
    }
}