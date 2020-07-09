package com.example.toymvpgithubapi.ui.recent

import android.annotation.SuppressLint
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.data.room.UserDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers


class RecentPresenter : RecentContract.Presenter {


    private lateinit var view: RecentContract.View
    private var disposable = CompositeDisposable()

    override fun setView(view: RecentContract.View) {
        this.view = view
    }

    override fun releaseView() {
        disposable.clear()
    }

    @SuppressLint("CheckResult")
    override fun loadData(userDao: UserDao) {
        userDao.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.setItem(ArrayList(it))
            }, {

            }).addTo(disposable)
    }

    @SuppressLint("CheckResult")
    override fun delete(userDao: UserDao, user: User) {
        Observable.just(user)
            .subscribeOn(Schedulers.io())
            .subscribe({
                userDao.delete(user)
            }, {

            })

    }

    @SuppressLint("CheckResult")
    override fun clearAll(userDao: UserDao) {
        Observable.just("clear All")
            .subscribeOn(Schedulers.io())
            .subscribe({
                userDao.clearAll()
            },{

            })
    }


}