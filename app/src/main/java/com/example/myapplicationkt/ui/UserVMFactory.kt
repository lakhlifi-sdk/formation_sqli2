package com.example.myapplicationkt.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationkt.models.UserRepository

class UserVMFactory(private val repo: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
