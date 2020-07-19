package com.mondayjob.mondayjob.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.mondayjob.mondayjob.R


class JobsAdapter(val activity: FragmentActivity?) : RecyclerView.Adapter<JobsAdapter.MyViewHolderJobs>() {
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderJobs {
        return MyViewHolderJobs(LayoutInflater.from(activity).inflate(R.layout.item_jobs, parent, false))
    }

    override fun getItemCount(): Int {
        return  15
    }

    override fun onBindViewHolder(holder: MyViewHolderJobs, position: Int) {

    }
    inner class MyViewHolderJobs(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View) {
            onItemClick?.invoke(adapterPosition, v)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

}





