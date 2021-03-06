package com.example.toymvpgithubapi.ui.detail

import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.data.room.UserDao
import com.example.toymvpgithubapi.application.base.BaseContract


interface DetailContract {

    interface View:BaseContract.View{
        fun setItem(user:User)
        fun updateLike(like:Int)
    }


    interface Presenter:BaseContract.Presenter<View>{
        fun recommendUser(dao:UserDao, user: User)
        fun loadData(activity: DetailActivity)
    }
}