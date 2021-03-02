package com.ayushidoshi56.fetchgithubapi.api

import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users")
    fun getpost(): Call<List<ApiResponse>>

    @GET("users/{login}")
    fun getuser(@Path("login")id:String):Call<UserResponse>

}