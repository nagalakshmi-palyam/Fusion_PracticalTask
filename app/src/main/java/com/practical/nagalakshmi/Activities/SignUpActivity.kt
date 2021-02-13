package com.practical.nagalakshmi.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.practical.nagalakshmi.R
import com.practical.nagalakshmi.RoomDatabase.UserSignUpDetails
import com.practical.nagalakshmi.ViewModel.UserSignUpViewModel
import com.practical.nagalakshmi.ViewModel.UserSignUpViewModelFactory
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), View.OnClickListener{
    //** It Registers user Details into Database **///

    private lateinit var userSignUpViewModel: UserSignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initViews()
    }

    fun initViews(){
        userSignUpViewModel=UserSignUpViewModelFactory(this).create(UserSignUpViewModel::class.java)
        btnSignUp.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnSignUp->{
                if(isDataValid()){
                 userSignUpViewModel.insertDetailstoDatabase(
                     firstName = etFirstName.text.toString(),
                     lastName = etLastName.text.toString(),
                     mobileNumber = etMobileNumber.text.toString(),
                     emailId = etEmail.text.toString(),
                     passWord = etPassword.text.toString(),
                     gender = etGender.text.toString())
                }
                val intent=Intent(this@SignUpActivity,LoginActivity::class.java)
                intent.putExtra("mobileNo",etMobileNumber.text.toString())
                intent.putExtra("passWord",etPassword.text.toString())
                startActivity(intent)
            }
        }
    }
    fun isDataValid(): Boolean {
        if (etFirstName.text.toString().isEmpty()) {
            etFirstName.error = "FirstName Can not be empty"
            return false
        }

        if (etLastName.text.toString().isEmpty()) {
            etLastName.error = "LastName cannot be empty"
            return false
        }
        if (etMobileNumber.text.toString().isEmpty()) {
            etMobileNumber.error = "Please Enter Mobile Number"
            return false
        }
        if (etGender.text.toString().isEmpty()) {
            etGender.error = "gender cannot be empty"
            return false
        }
        if (etEmail.text.toString().isEmpty()) {
            etEmail.error = "Please Enter Email"
            return false
        }
        if(etPassword.text.toString().isEmpty()){
            etPassword.error="Password Should not be Empty"
            return false
        }
        return true
    }
}