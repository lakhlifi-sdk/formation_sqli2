package com.example.myapplicationkt.models

data class User(var code: Int, var name : String, var email: String, var age: Int, var avatar :String){
    override fun toString(): String {
        //return super.toString()
        return "$code name : $name  email: $email avatar $avatar"
    }
}



