package com.example.toymvpgithubapi.ui.main

import com.example.toymvpgithubapi.ui.application.base.BaseContract
import com.example.toymvpgithubapi.data.model.User


interface MainContract {
    interface View : BaseContract.View{

        fun setItems(items:ArrayList<User>)
        fun updateView(user: User)

    }

    interface Presenter : BaseContract.Presenter<View>{

        fun loadData()
        fun evenetListen()


    }
}