package com.devmohammadi.constraintlayout.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmohammadi.constraintlayout.R
import com.devmohammadi.constraintlayout.databinding.ActivityDetailBinding
import com.devmohammadi.constraintlayout.ui.detail.adapter.HouseInfoAdapter
import com.devmohammadi.constraintlayout.ui.detail.model.HouseInfo
import com.devmohammadi.constraintlayout.utils.BUNDLE_ADDRESS
import com.devmohammadi.constraintlayout.utils.BUNDLE_IMAGE
import com.devmohammadi.constraintlayout.utils.BUNDLE_PRICE

class DetailActivity : AppCompatActivity() {

    //Bundle
    private lateinit var bundle: Bundle

    //Other
    private val housesInfoList: MutableList<HouseInfo> = mutableListOf()
    private lateinit var houseInfoAdapter: HouseInfoAdapter

    //Binding
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize
        bundle = intent.extras!!
        //Set data
        bundle.let {
            binding.ivDetailPageHeaderImage.setImageResource(it.getInt(BUNDLE_IMAGE))
            binding.tvDetailPagePrice.text = it.getString(BUNDLE_PRICE)
            binding.tvDetailPageAddress.text = it.getString(BUNDLE_ADDRESS)
        }
        //House info
        addHouseInfo()
        houseInfoAdapter = HouseInfoAdapter(housesInfoList)
        binding.rvInfo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvInfo.adapter = houseInfoAdapter
        //Back
        binding.rvInfo.setOnClickListener { onBackPressed() }

    }

    private fun addHouseInfo() {
        housesInfoList.add(HouseInfo(500, "Square foot"))
        housesInfoList.add(HouseInfo(4, "Bedrooms"))
        housesInfoList.add(HouseInfo(2, "Bathrooms"))
        housesInfoList.add(HouseInfo(1, "Toilet"))
        housesInfoList.add(HouseInfo(2, "Garage"))
        housesInfoList.add(HouseInfo(1, "Elevator"))
    }

}