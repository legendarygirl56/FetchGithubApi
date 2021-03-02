package com.ayushidoshi56.fetchgithubapi.api

import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
// 3rd step
// Service ->can be multiple ->  GET POST REQUESTS
// Client-> mostly 1 as mostly base url is same for all cases ->Requests are called from Client ->Manages all the networking part
//interface-> we do not define function in interface just declare it
//retrofit manages all the get requests otherwise using Okhttp the code will be very lengthy.

interface GithubApi {

    //if we need to pass any parameters then we need to use queries like longitude latitude in case of a weather app
    //Here we donot need query as this is static api
    //Using Call we need not use Coroutines
    //enqueue function(related to Call) manages all the Coroutine part internally and we need not do it.
    //enqueue->FOUND IN Repository Class
    @GET("users")
    fun getpost(): Call<List<ApiResponse>>   //need to get list of users so using List


    @GET("users/{login}")
    fun getuser(@Path("login")id:String):Call<UserResponse>   //want data of only one user

}