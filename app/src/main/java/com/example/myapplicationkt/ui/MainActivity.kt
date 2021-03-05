package com.example.myapplicationkt.ui

import com.example.myapplicationkt.Adapters.users
import UserAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationkt.R
import com.example.myapplicationkt.models.User
import com.example.myapplicationkt.models.UserRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo=UserRepository();
        //val rvUsers = findViewById<View>(R.id.rvUsers) as RecyclerView
        val rvUsers : RecyclerView = findViewById(R.id.rvUsers)
        // Initialize users
        // Create adapter passing in the sample user data
       // val adapter = UserAdapter(users,applicationContext)
        val adapter = UserAdapter( this)
        // Attach the adapter to the recyclerview to populate items
        rvUsers.adapter = adapter

        //call view Model ->UserViewModel
        val viewModel: UserViewModel = ViewModelProvider(this, UserVMFactory(repo)).get(UserViewModel::class.java)
        viewModel.userList.observe(this, Observer<MutableList<User>> ()  {
            adapter.setAndRefresh(it)
        })

        // Set layout manager to position the items
        rvUsers.layoutManager = LinearLayoutManager(this)
        // That's all!
    }
}