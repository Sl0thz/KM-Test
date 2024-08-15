package com.example.kmtest.view

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kmtest.data.response.DataItem
import com.example.kmtest.data.response.GetUserResponse
import com.example.kmtest.data.retrofit.ConfigApi
import retrofit2.Call
import retrofit2.Response

class ThirdViewModel : ViewModel() {
    private val _dataItem = MutableLiveData<List<DataItem>>()
    val dataItem: LiveData<List<DataItem>> = _dataItem

    fun getUsers(){
        val client = ConfigApi.getApiService().getUsers()
        client.enqueue(object : retrofit2.Callback<GetUserResponse>{
            override fun onResponse(
                call: Call<GetUserResponse>,
                response: Response<GetUserResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null){
                        _dataItem.value = responseBody.data
                    }
                } else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}