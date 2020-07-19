package com.mondayjob.mondayjob.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.mondayjob.mondayjob.R

class BrowseCategoryAdapter(val activity: FragmentActivity?) : RecyclerView.Adapter<MyViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_browse_categories, parent, false))
    }

    override fun getItemCount(): Int {
        return  15
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

}
