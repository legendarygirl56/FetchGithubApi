package com.ayushidoshi56.fetchgithubapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.model.UserResponse
import com.ayushidoshi56.fetchgithubapi.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel2(private val repository: Repository) :ViewModel() {
    var myResponse: MutableLiveData<UserResponse> = MutableLiveData()
    fun getPostViewModel(login:String)
    {
        viewModelScope.launch {
            repository.getUser(login)
            myResponse=repository.userData
        }
    }
}