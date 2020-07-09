package com.example.toymvpgithubapi.ui.detail

import android.content.Context
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.ui.application.base.BaseContract
import com.example.toymvpgithubapi.ui.main.MainContract


interface DetailContract {

    interface View:BaseContract.View{
        fun setItem(user:User)
        fun updateLike(like:Int)
    }


    interface Presenter:BaseContract.Presenter<View>{
        fun recommendUser(user: User)
        fun loadData(activity: DetailActivity)
    }
}