package com.ayushidoshi56.fetchgithubapi.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//2nd step
//Make a Client which contains the base url.

class RetrofitClient {

    //GithubApi is a service
    val githubApi:GithubApi

    //Made a static member in the class which is itself the object -> companion object.
    //We can call static member without creating the object.
    //Now we need not create objects again and again and neednot initialise it again and again.
    companion object{
        private var retrofitClient:RetrofitClient?=null
        val instance:RetrofitClient get(){
            if(retrofitClient==null)                        //if null then initialise
            {
                retrofitClient= RetrofitClient()
            }
            return retrofitClient as RetrofitClient         // else pass it directly
        }
    }

    //initialisation
    init {

        //Converts the names in Json file -> to capital letters and without underscore
        val gson=GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

        //Converter Factory -> Json is converted into ApiResponse type
        //Right now we are not converting it just giving and initialising the converter -> retrofit
        //Gson is a library
        //Need to pass the base url
        val retrofit= Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        //We are telling service that this is the client we have
        githubApi=retrofit.create(GithubApi::class.java)
    }
}