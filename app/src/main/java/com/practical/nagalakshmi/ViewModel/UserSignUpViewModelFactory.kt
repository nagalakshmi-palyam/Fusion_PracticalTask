package com.practical.nagalakshmi.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserSignUpViewModelFactory(private val context: Context): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserSignUpViewModel::class.java)) {
            return UserSignUpViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}