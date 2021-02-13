package com.practical.nagalakshmi.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.practical.nagalakshmi.R
import com.practical.nagalakshmi.ViewModel.UserSignUpViewModel
import com.practical.nagalakshmi.ViewModel.UserSignUpViewModelFactory
import com.practical.nagalakshmi.ViewModelForLogIn.LogInViewModel
import com.practical.nagalakshmi.ViewModelForLogIn.LogInViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    //** LogInActivity Validates the UserLogIn Details  **//

    private lateinit var logInViewModel: LogInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }
    override fun onClick(v: View?) {
        when(v?.id){
        R.id.btnlogin->{
            if(isDataValid()){
                logInViewModel.fetchdataFromDatabse(etmobileNumberLogin.text.toString(),etPasswordLogin.text.toString()).observe(this, Observer{
                    if (it!=null){
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        intent.putExtra("firstName", it.firstName)
                        intent.putExtra("lastName", it.lastName)
                        intent.putExtra("gender", it.gender)
                        intent.putExtra("emailId", it.emailId)
                        startActivity(intent)
                    } else{
                        Toast.makeText(this@LoginActivity,"User not found", Toast.LENGTH_SHORT).show()
                    }

                }
                )
            }
          }
            R.id.tvsignUp->{
                val intent= Intent(this@LoginActivity,SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun initViews(){
        btnlogin.setOnClickListener(this)
        tvsignUp.setOnClickListener(this)
        logInViewModel=LogInViewModelFactory(this).create(LogInViewModel::class.java)
    }

    fun isDataValid(): Boolean {
        if (etmobileNumberLogin.text.toString().isEmpty()) {
            etmobileNumberLogin.error = "Please Enter Mobile Number"
            return false
        }
        if(etPasswordLogin.text.toString().isEmpty()){
            etPasswordLogin.error="Password Should not be Empty"
            return false
        }
        return true
    }

}