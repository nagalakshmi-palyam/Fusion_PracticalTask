package com.practical.nagalakshmi.ViewModelForLogIn

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Database
import com.practical.nagalakshmi.RoomDatabase.UserDetailsDatabase
import com.practical.nagalakshmi.RoomDatabase.UserDetailsDatabase.Companion.getInstance
import com.practical.nagalakshmi.RoomDatabase.UserSignUpDetails

class LogInViewModel(private val context: Context): ViewModel()  {
    fun fetchdataFromDatabse(mobileNumber:String,passWord:String): LiveData<UserSignUpDetails> {
        return UserDetailsDatabase.getInstance(context).userDetailsDao.getUserDetails(mobileNumber,passWord)
    }
}