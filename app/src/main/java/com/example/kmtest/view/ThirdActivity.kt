package com.example.kmtest.view

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmtest.data.response.DataItem
import com.example.kmtest.databinding.ThirdScreenBinding
import com.example.kmtest.view.adapter.Adapter
import com.google.android.gms.ads.MobileAds

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ThirdScreenBinding
    private lateinit var thirdViewModel: ThirdViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MobileAds.initialize(this) {}


        setupAction()
        thirdViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ThirdViewModel::class.java]
        thirdViewModel.dataItem.observe(this){ dataItem ->
            setData(dataItem)
        }
        thirdViewModel.getUsers()
    }

    private fun setupAction() {
        binding.btBack.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun setData(data: List<DataItem>) {
        val adapter = Adapter().apply {
            submitList(data)
        }
        binding.itemRow.layoutManager = LinearLayoutManager(this)
        binding.itemRow.adapter = adapter
    }

    companion object{
        const val DETAIL = "DETAIL"
    }
}