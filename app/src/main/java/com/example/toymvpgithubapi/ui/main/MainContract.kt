package com.example.toymvpgithubapi.ui.main

import com.example.toymvpgithubapi.application.base.BaseContract
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.data.room.UserDao


interface MainContract {
    interface View : BaseContract.View{

        fun setItems(items:ArrayList<User>)
        fun updateView(user: User)

    }

    interface Presenter : BaseContract.Presenter<View>{
        fun loadData()
        fun eventListener()
        fun addUser(userDao:UserDao,user:User)
    }
}