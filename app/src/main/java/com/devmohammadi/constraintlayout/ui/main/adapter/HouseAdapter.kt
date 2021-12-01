package com.devmohammadi.constraintlayout.ui.main.adapter

import com.devmohammadi.constraintlayout.utils.BUNDLE_ADDRESS
import com.devmohammadi.constraintlayout.utils.BUNDLE_IMAGE
import com.devmohammadi.constraintlayout.utils.BUNDLE_PRICE
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devmohammadi.constraintlayout.R
import com.devmohammadi.constraintlayout.ui.detail.DetailActivity
import com.devmohammadi.constraintlayout.ui.main.model.HousesModel

class HouseAdapter constructor(private val items: MutableList<HousesModel>) :
    RecyclerView.Adapter<HouseAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        return ViewHolder(inflater.inflate(R.layout.row_house_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image = itemView.findViewById<ImageView>(R.id.houseRowImage)
        private val price = itemView.findViewById<TextView>(R.id.houseRowPrice)
        private val address = itemView.findViewById<TextView>(R.id.houseRowAddress)
        private val info = itemView.findViewById<TextView>(R.id.houseRowInfo)

        @SuppressLint("SetTextI18n")
        fun bind(item: HousesModel) {
            image.setImageResource(item.img)
            price.text = item.price
            address.text = item.address
            info.text = "${item.bedroom} bedrooms / ${item.bathrooms} bathrooms / ${item.area} ft"
            //Click
            itemView.setOnClickListener {
                Intent(context, DetailActivity::class.java).apply {
                    this.putExtra(BUNDLE_IMAGE, item.img)
                    this.putExtra(BUNDLE_PRICE, item.price)
                    this.putExtra(BUNDLE_ADDRESS, item.address)
                    context.startActivity(this)
                }
            }
        }
    }
}