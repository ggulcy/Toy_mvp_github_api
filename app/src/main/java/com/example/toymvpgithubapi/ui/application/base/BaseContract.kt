package com.example.toymvpgithubapi.ui.application.base




class BaseContract {
    interface View{
        fun showProgress()
        fun hideProgress()
    }


    interface Presenter<T>{
        fun setView(view:T)
        fun releaseView()
    }


}