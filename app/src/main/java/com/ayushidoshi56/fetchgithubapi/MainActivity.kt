package com.ayushidoshi56.fetchgithubapi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayushidoshi56.fetchgithubapi.RecyclerView.ListAdapter
import com.ayushidoshi56.fetchgithubapi.databinding.ActivityMainBinding
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.ayushidoshi56.fetchgithubapi.repository.Repository

//5th step
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    private lateinit var binding:ActivityMainBinding
    val listAdapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)

        binding.rv.layoutManager=LinearLayoutManager(this)
        binding.rv.adapter=listAdapter

        val repository= Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPostViewModel()//calling inside view model

        //val text = findViewById<TextView>(R.id.txt1)

        //can observe the data from here
        viewModel.myResponse.observe(this, Observer { response ->

            //listAdapter is already created earlier and now just we are swapping the values in the empty spaces.
            //Recycler view
            listAdapter.swapData(response as MutableList<ApiResponse>)
        });

        //when an item gets clicked inside the recycler view it gets called.
        //we are also passing the string will the clicking
        //role of 2nd api gets started
        //we pass the 2nd activity and pass the string to it using putExtra
        listAdapter.onItemClick={
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Login", it)
            startActivity(intent)
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}