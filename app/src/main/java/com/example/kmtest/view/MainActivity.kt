package com.example.kmtest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kmtest.databinding.ActivityMainBinding
import com.google.android.ads.mediationtestsuite.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        palindrome()
        nextButton()
    }

    private fun palindrome(){
        val checkButton = binding.checkButton

        checkButton.setOnClickListener {
            val name = binding.name.text.toString()
            val sentence = binding.palindrome.text.toString()

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(sentence)) {
                Toast.makeText(this, "Please enter both name and sentence", Toast.LENGTH_SHORT).show()
            } else {
                val isPalindrome = isPalindrome(sentence)
                val message = if (isPalindrome) "isPalindrome" else "not palindrome"

                AlertDialog.Builder(this)
                    .setTitle("Palindrome Check")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }

    private fun isPalindrome(text: String): Boolean {
        val cleanText = text.replace("\\s".toRegex(), "").lowercase()
        return cleanText == cleanText.reversed()
    }

    private fun nextButton(){
        binding.nextButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}