package com.example.toymvpgithubapi.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.toymvpgithubapi.ui.application.base.BaseActivity
import com.example.toymvpgithubapi.R
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.ui.application.navigator.Navigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , MainContract.View {


    private val presenter = MainPresenter()
    private val mainAdapter = MainAdapter()
    private val navigator = Navigator()
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
        presenter.loadData()

        mainAdapter.onItemClick = { navigator.toDetail(this,it) }

        presenter.evenetListen()


    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.releaseView()
    }

    override fun showProgress() {
//        showToast("show toast")
    }

    override fun hideProgress() {
//        showToast("show toast")
    }

    override fun setItems(items: ArrayList<User>) {
        recylcer_view.adapter = mainAdapter.apply {
            this.collections = items
        }
    }

    override fun updateView(user: User) {
        mainAdapter.updateView(user)
    }
}