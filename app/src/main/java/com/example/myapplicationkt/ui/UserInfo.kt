package com.example.myapplicationkt.ui

import com.example.myapplicationkt.Adapters.users
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplicationkt.R

class UserInfo() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        init()
    }

    fun init(){
        //receive code of user
        val extras = intent.extras ?: return
        val code = extras.getInt("code")
        var user=users.find { it.code==code }
        val user_name = findViewById<TextView>(R.id.user_name_info)
        val user_email = findViewById<TextView>(R.id.user_email_info)
        val user_age = findViewById<TextView>(R.id.user_age_info)
        user_name.setText(user?.name)
        user_email.setText(user?.email)
        user_age.setText(""+user?.age)
        print("---------------------->"+user)
    }
}