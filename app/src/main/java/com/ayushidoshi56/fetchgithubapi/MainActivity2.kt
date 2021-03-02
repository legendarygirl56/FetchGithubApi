package com.ayushidoshi56.fetchgithubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayushidoshi56.fetchgithubapi.databinding.ActivityMain2Binding
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.repository.Repository

class MainActivity2 : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel2
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var login: String = intent.getStringExtra("Login")
        binding= ActivityMain2Binding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)

        val repository= Repository()
        val viewModelFactory = MainViewModelFactory2(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel2::class.java)
        viewModel.getPostViewModel(login)

        Toast.makeText(this,"T",Toast.LENGTH_LONG).show()
        //val text = findViewById<TextView>(R.id.txt1)

        viewModel.myResponse.observe(this, Observer { response ->
            //Toast.makeText(this,"HEL",Toast.LENGTH_LONG).show()
            //Log.i("TAG",response.toString())
            binding.tv.text=response.toString()
        });
    }
}