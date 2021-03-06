package com.ayushidoshi56.fetchgithubapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ayushidoshi56.fetchgithubapi.repository.Repository

//used for joining view and view model
//always same code as it is
class MainViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}