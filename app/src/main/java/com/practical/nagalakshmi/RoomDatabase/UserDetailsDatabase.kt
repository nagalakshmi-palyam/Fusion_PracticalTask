package com.practical.nagalakshmi.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities= [UserSignUpDetails::class], version = 1, exportSchema = false)
abstract class UserDetailsDatabase: RoomDatabase() {
    abstract val userDetailsDao:UserDetailsDao
    companion object{
        private var INSTANCE: UserDetailsDatabase? = null
        fun getInstance(context: Context): UserDetailsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, UserDetailsDatabase::class.java, "userprofile_DB").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}