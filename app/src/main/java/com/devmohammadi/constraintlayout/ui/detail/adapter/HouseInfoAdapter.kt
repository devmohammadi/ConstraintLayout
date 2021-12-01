package com.devmohammadi.constraintlayout.ui.detail.adapter

import com.devmohammadi.constraintlayout.ui.detail.model.HouseInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devmohammadi.constraintlayout.R

class HouseInfoAdapter constructor(private val items: MutableList<HouseInfo>) :
    RecyclerView.Adapter<HouseInfoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.row_info_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val number = itemView.findViewById<TextView>(R.id.rowHousesInfo_numberTxt)
        private val desc = itemView.findViewById<TextView>(R.id.rowHousesInfo_descTxt)

        fun bind(item: HouseInfo) {
            number.text = item.number.toString()
            desc.text = item.title
        }
    }
}