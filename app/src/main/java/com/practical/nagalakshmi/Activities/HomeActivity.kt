package com.practical.nagalakshmi.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.practical.nagalakshmi.R
import com.practical.nagalakshmi.RoomDatabase.UserSignUpDetails
import com.practical.nagalakshmi.ViewModel.UserSignUpViewModel
import com.practical.nagalakshmi.ViewModel.UserSignUpViewModelFactory
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    //** Home Activity Populates the userProfile Details **//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
    }
    fun initViews(){
     tvFirstName.text=intent.getStringExtra("firstName")
     tvLastName.text=intent.getStringExtra("lastName")
     tvEmail.text=intent.getStringExtra("emailId")
     tvGender.text=intent.getStringExtra("gender")
    }



}