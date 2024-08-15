package com.example.kmtest.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kmtest.databinding.SecondScreenBinding

class SecondActivity : AppCompatActivity(){
    private lateinit var binding: SecondScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction(){
        binding.btBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.chooseButton.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}