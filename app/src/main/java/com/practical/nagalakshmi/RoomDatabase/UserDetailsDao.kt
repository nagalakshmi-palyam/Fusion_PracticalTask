package com.practical.nagalakshmi.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDetailsDao {
    @Insert
    suspend fun insertUserDetails(userSignUpDetails: UserSignUpDetails)
    @Query("Select * From userDetails where mobileNumber= :mobileNumber and passWord= :password")
    fun getUserDetails(mobileNumber:String,password:String): LiveData<UserSignUpDetails>
}