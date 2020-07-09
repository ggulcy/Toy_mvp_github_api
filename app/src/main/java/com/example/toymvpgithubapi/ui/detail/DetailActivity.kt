package com.example.toymvpgithubapi.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.toymvpgithubapi.ui.application.base.BaseActivity
import com.example.toymvpgithubapi.R
import com.example.toymvpgithubapi.data.model.User
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.iv_thumb
import kotlinx.android.synthetic.main.activity_detail.tv_name

class DetailActivity : BaseActivity() , DetailContract.View{

    private val presenter = DetailPresenter()
    private lateinit var user:User

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        presenter.setView(this)
        presenter.loadData(this)

        btn_like.setOnClickListener {
            presenter.recommendUser(user)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.releaseView()
    }

    override fun setItem(mUser: User) {
        this.user = mUser
        tv_email.text = user.email
        tv_name.text = user.name.first + user.name.last
        Glide.with(this)
            .load(user.picture.large)
            .into(iv_thumb)
        tv_like.text = user.like.toString()
    }

    override fun updateLike(like: Int) {
        tv_like.text = like.toString()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

}