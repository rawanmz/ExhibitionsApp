package com.example.exhibitionsapp.ui.home

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exhibitionsapp.R

class HomeListAdapter(val dataList: List<String>) :
    RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    class HomeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val testTex: TextView = view.findViewById(R.id.testText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val contentView = inflater.inflate(R.layout.home_list_item, parent, false)
        return HomeListViewHolder(contentView)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.testTex.text = dataList[position]
    }
}

