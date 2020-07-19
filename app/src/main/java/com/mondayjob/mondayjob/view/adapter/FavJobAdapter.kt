package com.mondayjob.mondayjob.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.mondayjob.mondayjob.R

class FavJobAdapter(val activity: FragmentActivity?) : RecyclerView.Adapter<FavJobAdapter.MyViewHolderFav>()  {
    var onItemClick: ((pos: Int, view: View) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderFav {
        return MyViewHolderFav(LayoutInflater.from(activity).inflate(R.layout.item_fav_list, parent, false))
    }

    override fun getItemCount(): Int {
        return  15
    }

    override fun onBindViewHolder(holder: MyViewHolderFav, position: Int) {

    }
    inner class MyViewHolderFav(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View) {
            onItemClick?.invoke(adapterPosition, v)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}

