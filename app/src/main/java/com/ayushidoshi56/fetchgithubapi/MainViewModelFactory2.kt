package com.ayushidoshi56.fetchgithubapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ayushidoshi56.fetchgithubapi.repository.Repository

class MainViewModelFactory2(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel2(repository) as T
    }
}