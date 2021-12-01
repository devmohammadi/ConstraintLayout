package com.devmohammadi.constraintlayout.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmohammadi.constraintlayout.R
import com.devmohammadi.constraintlayout.ui.main.adapter.FilterAdapter
import com.devmohammadi.constraintlayout.databinding.ActivityMainBinding
import com.devmohammadi.constraintlayout.ui.main.adapter.HouseAdapter
import com.devmohammadi.constraintlayout.ui.main.model.HousesModel

class MainActivity : AppCompatActivity() {

    private val filtersList: MutableList<String> = mutableListOf()
    private val housesList: MutableList<HousesModel> = mutableListOf()
    private lateinit var filterAdapter: FilterAdapter
    private lateinit var houseAdapter: HouseAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addFiltersList()
        setupRecyclerViewFilter()
        addHousesList()
        setupRecyclerViewHouse()
    }

    private fun setupRecyclerViewHouse() {
        filterAdapter = FilterAdapter(filtersList)
        binding.rvFilter.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvFilter.adapter = filterAdapter
    }

    private fun setupRecyclerViewFilter() {
        houseAdapter = HouseAdapter(housesList)
        binding.rvHouses.layoutManager =
            LinearLayoutManager(this)
        binding.rvHouses.adapter = houseAdapter
    }

    private fun addFiltersList() {
        filtersList.add("< $220.000")
        filtersList.add("For Sale")
        filtersList.add("3-4 Beds")
        filtersList.add("5 Beds")
        filtersList.add("With Garage")
        filtersList.add("With Foreigner")
        filtersList.add("With Elevator")
    }


    private fun addHousesList() {
        housesList.add(
            HousesModel(
                R.drawable.house1,
                "$200.000",
                "Jenison, Ml 49428, SF",
                4,
                2,
                1.416f
            )
        )
        housesList.add(
            HousesModel(
                R.drawable.house2,
                "$140.000",
                "351 Rockwood Dr, SF",
                2,
                1,
                0.580f
            )
        )
        housesList.add(
            HousesModel(
                R.drawable.house3,
                "$500.000",
                "214 JakeNorton, EF",
                5,
                3,
                2.632f
            )
        )
        housesList.add(HousesModel(R.drawable.house4, "$290.000", "DrKeyOk 2549, SF", 3, 2, 1.967f))
        housesList.add(
            HousesModel(
                R.drawable.house5,
                "$350.000",
                "Lambers, Ml 500, EF",
                2,
                2,
                2.240f
            )
        )
    }

}