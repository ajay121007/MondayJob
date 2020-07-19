package com.mondayjob.mondayjob.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.mondayjob.mondayjob.R

class JobsHistoryAdapter(val activity: FragmentActivity?) : RecyclerView.Adapter<JobsHistoryAdapter.MyViewHolderHistory>()  {
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderHistory {
        return MyViewHolderHistory(LayoutInflater.from(activity).inflate(R.layout.item_job_history, parent, false))
    }

    override fun getItemCount(): Int {
        return  15
    }

    override fun onBindViewHolder(holder: MyViewHolderHistory, position: Int) {

    }
    inner class MyViewHolderHistory(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View) {
            onItemClick?.invoke(adapterPosition, v)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}