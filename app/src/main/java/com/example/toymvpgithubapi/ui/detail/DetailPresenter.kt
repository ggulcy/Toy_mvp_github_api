package com.example.toymvpgithubapi.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.data.room.UserDao
import com.example.toymvpgithubapi.ui.LikeEvent
import com.example.toymvpgithubapi.ui.RxEvent
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers


class DetailPresenter : DetailContract.Presenter{


    private lateinit var view:DetailContract.View
    private var disposable = CompositeDisposable()
    override fun setView(view: DetailContract.View) {
        this.view = view
    }

    override fun releaseView() {
        disposable.clear()
    }

    @SuppressLint("CheckResult")
    override fun recommendUser(userDao: UserDao, user: User) {
        user.like++
        view.updateLike(user.like)
        RxEvent.sendEvent(LikeEvent(user))

        Observable.just(user)
            .subscribeOn(Schedulers.io())
            .subscribe({
                userDao.update(user)
            },{

            }).addTo(disposable)
    }

    override fun loadData(activity: DetailActivity) {
        view.setItem(activity.intent.getSerializableExtra("User") as User)
    }


}