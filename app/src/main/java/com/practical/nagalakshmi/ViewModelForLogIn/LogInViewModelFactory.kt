package com.practical.nagalakshmi.ViewModelForLogIn

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practical.nagalakshmi.ViewModel.UserSignUpViewModel

class LogInViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LogInViewModel::class.java)) {
            return LogInViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}