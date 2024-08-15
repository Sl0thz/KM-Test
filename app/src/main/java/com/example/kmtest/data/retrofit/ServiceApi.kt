package com.example.kmtest.data.retrofit

import com.example.kmtest.data.response.GetUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {
    @GET("api/users")
    fun getUsers(): Call<GetUserResponse>
}