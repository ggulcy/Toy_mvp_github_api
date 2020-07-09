package com.example.toymvpgithubapi.ui.recent

import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.data.room.UserDao
import com.example.toymvpgithubapi.application.base.BaseContract


interface RecentContract {

    interface View:BaseContract.View{
        fun setItem(items:ArrayList<User>)
    }


    interface Presenter:BaseContract.Presenter<View>{
        fun loadData(user:UserDao)
        fun delete(userDao: UserDao, user:User)
        fun clearAll(user: UserDao)
    }
}