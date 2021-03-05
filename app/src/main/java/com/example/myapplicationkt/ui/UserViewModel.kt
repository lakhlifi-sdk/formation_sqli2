package com.example.myapplicationkt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationkt.Adapters.users
import com.example.myapplicationkt.models.User
import com.example.myapplicationkt.models.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(repo: UserRepository) : ViewModel() {

    lateinit var userList : MutableLiveData<MutableList<User>>
    init {
        viewModelScope.launch {
            userList = repo.getListOfUser()
        }
    }
}