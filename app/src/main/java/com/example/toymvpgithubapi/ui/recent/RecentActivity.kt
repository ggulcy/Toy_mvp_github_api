package com.example.toymvpgithubapi.ui.recent

import android.annotation.SuppressLint
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.toymvpgithubapi.application.base.BaseActivity
import com.example.toymvpgithubapi.R
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.data.room.UserDatabase
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.iv_thumb
import kotlinx.android.synthetic.main.activity_detail.tv_name
import kotlinx.android.synthetic.main.activity_recent.*

class RecentActivity : BaseActivity() , RecentContract.View{


    private val presenter = RecentPresenter()
    private val mAdapter = RecentAdapter()
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent)

        presenter.setView(this)
        presenter.loadData(UserDatabase.getInstance(this)!!.getUserDao())


        mAdapter.onItemClick = {
            presenter.delete(UserDatabase.getInstance(this)!!.getUserDao(),it)
        }

    }

    override fun setItem(items: ArrayList<User>) {
        recylcer_view.adapter = mAdapter.apply {
            collections = items
        }
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.releaseView()
    }

}