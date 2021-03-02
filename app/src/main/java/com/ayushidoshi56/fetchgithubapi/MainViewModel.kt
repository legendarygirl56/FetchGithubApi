package com.ayushidoshi56.fetchgithubapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    var myResponse: MutableLiveData<List<ApiResponse>> = MutableLiveData()
    fun getPostViewModel()
    {
        viewModelScope.launch {
            repository.getPost()
            myResponse=repository._downloadedData
        }
    }
}