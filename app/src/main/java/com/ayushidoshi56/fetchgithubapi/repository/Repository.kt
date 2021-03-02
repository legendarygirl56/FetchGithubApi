package com.ayushidoshi56.fetchgithubapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ayushidoshi56.fetchgithubapi.api.RetrofitClient
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    var _downloadedData= MutableLiveData<List<ApiResponse>>()
    var userData =MutableLiveData<UserResponse>()
    fun getPost(){
        RetrofitClient.instance.githubApi.getpost()
            .enqueue(object : Callback<List<ApiResponse>> {
                override fun onResponse(
                    call: Call<List<ApiResponse>>,
                    response: Response<List<ApiResponse>>
                ){
                    if (response.isSuccessful) {
                        _downloadedData.postValue(response.body())
                    } else {

                    }
                }

                override fun onFailure(call: Call<List<ApiResponse>>, t: Throwable) {

                }
            })

    }

    fun getUser(login:String){
        RetrofitClient.instance.githubApi.getuser(login)
            .enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ){
                    if (response.isSuccessful) {
                        userData.postValue(response.body())
                    } else {

                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {

                }
            })

    }
}