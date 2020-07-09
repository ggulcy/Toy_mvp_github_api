package com.example.toymvpgithubapi.ui.detail

import android.content.Context
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.ui.LikeEvent
import com.example.toymvpgithubapi.ui.RxEvent


class DetailPresenter : DetailContract.Presenter{


    private lateinit var view:DetailContract.View
    override fun setView(view: DetailContract.View) {
        this.view = view
    }

    override fun releaseView() {

    }

    override fun recommendUser(user: User) {
        user.like++
        view.updateLike(user.like)

        RxEvent.sendEvent(LikeEvent(user))
    }

    override fun loadData(activity: DetailActivity) {
        view.setItem(activity.intent.getSerializableExtra("User") as User)
    }


}