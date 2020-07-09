package com.example.toymvpgithubapi.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.toymvpgithubapi.data.model.User


@Database(entities = [User::class],version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao():UserDao

    companion object{
        private var INSTANCE:UserDatabase? = null

        fun getInstance(context: Context):UserDatabase?{
            if(INSTANCE == null){
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        UserDatabase::class.java,
                        "chanhyeok.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}



