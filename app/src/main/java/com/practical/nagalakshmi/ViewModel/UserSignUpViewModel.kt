package com.practical.nagalakshmi.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.practical.nagalakshmi.RoomDatabase.UserDetailsDatabase
import com.practical.nagalakshmi.RoomDatabase.UserSignUpDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserSignUpViewModel(private val context: Context): ViewModel() {
    private val repository = SignUpRepostory()
    fun insertDetailstoDatabase(firstName:String,lastName:String,mobileNumber:String,emailId:String,passWord:String,gender:String){
        repository.insertDetailstoRepository(
            firstName,lastName,mobileNumber,emailId,passWord,gender,context
        )
    }

}