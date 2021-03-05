package com.example.myapplicationkt.models

import androidx.lifecycle.MutableLiveData
import com.example.myapplicationkt.Adapters.users

class UserRepository {
    companion object {
        var instance: UserRepository? = null
        fun getRepo(): UserRepository = instance ?: UserRepository().apply { instance = this }
    }
    var userList: MutableLiveData<MutableList<User>> = MutableLiveData()
    suspend fun getListOfUser(): MutableLiveData<MutableList<User>> = userList.apply { value = users }
}