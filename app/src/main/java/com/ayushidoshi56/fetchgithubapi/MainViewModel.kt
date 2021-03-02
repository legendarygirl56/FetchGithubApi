package com.ayushidoshi56.fetchgithubapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.repository.Repository
import kotlinx.coroutines.launch
//5th step
//MVVM
//CALLING IN THIS MANNER
//VIEW->VIEWMODEL->REPO
// we cannot call repository directly from view(Main Act)
//Viewmodel makes data remained saved
//view keeps changing when you change the orientation of phone
class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<List<ApiResponse>> = MutableLiveData()

    fun getPostViewModel()
    {
        viewModelScope.launch {
            repository.getPost()    //calling repo from here
            myResponse=repository._downloadedData
        }
    }
}