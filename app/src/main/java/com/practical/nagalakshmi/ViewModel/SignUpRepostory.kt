package com.practical.nagalakshmi.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import com.practical.nagalakshmi.RoomDatabase.UserDetailsDatabase
import com.practical.nagalakshmi.RoomDatabase.UserSignUpDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpRepostory {
    fun insertDetailstoRepository(firstName:String,lastName:String,mobileNumber:String,emailId:String,passWord:String,gender:String,context:Context){
        CoroutineScope(Dispatchers.IO).launch {
            val userDetails = UserSignUpDetails(firstName = firstName,lastName = lastName,mobileNumber = mobileNumber,emailId = emailId,passWord = passWord,gender = gender)
            UserDetailsDatabase.getInstance(context).userDetailsDao.insertUserDetails(userDetails)
        }
    }
}