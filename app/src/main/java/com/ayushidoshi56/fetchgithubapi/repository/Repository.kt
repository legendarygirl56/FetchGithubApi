package com.ayushidoshi56.fetchgithubapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ayushidoshi56.fetchgithubapi.api.RetrofitClient
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//4th step
class Repository {

    //variable where data will be stored(response) of 1st API
    //Live data cannot be changed
    //Mutable live data can be changed
    var _downloadedData= MutableLiveData<List<ApiResponse>>()

    //variable where data will be stored(response) of 2nd API
    var userData =MutableLiveData<UserResponse>()

    //function for 1st API
    fun getPost(){

        //Retrofit class call
        //static member is instance that's why we are able to call directly from class name
        //githubApi is service and getpost() is function
        //instance is static object and now we can call other things of class directly from instance(object)
        RetrofitClient.instance.githubApi.getpost()
            .enqueue(object : Callback<List<ApiResponse>> { //enqueue -> queue which keeps pushing all the services and keeps executing them

                //enqueue contains two functions onResponse and on Failure

                //onResponse()
                override fun onResponse(
                    call: Call<List<ApiResponse>>,
                    response: Response<List<ApiResponse>>
                ){
                    if (response.isSuccessful) { //status code 200-300 between then successful
                        _downloadedData.postValue(response.body())      //for inserting in live data ->postValue is used
                    }
                    else {
                        //response came but is not successful
                        //bad request
                        //server down
                    }
                }

                //onFailure()
                override fun onFailure(call: Call<List<ApiResponse>>, t: Throwable) {
                    //no response
                }
            })

    }

    //function for 2nd API
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