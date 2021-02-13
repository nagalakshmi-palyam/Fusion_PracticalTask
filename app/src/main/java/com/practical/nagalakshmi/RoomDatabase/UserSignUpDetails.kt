package com.practical.nagalakshmi.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userDetails")
class UserSignUpDetails (
    @PrimaryKey(autoGenerate = true)
    var userid: Int = 0,
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @ColumnInfo(name= "mobileNumber")
    val mobileNumber:String,
    @ColumnInfo(name="emailId")
    val emailId:String,
    @ColumnInfo(name="gender")
    val gender:String,
    @ColumnInfo(name="passWord")
    val passWord:String
)