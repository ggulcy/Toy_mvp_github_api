package com.example.toymvpgithubapi.ui.main

import android.annotation.SuppressLint
import com.example.toymvpgithubapi.data.api.ApiProvider
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.ui.LikeEvent
import com.example.toymvpgithubapi.ui.RxEvent
import com.example.toymvpgithubapi.ui.main.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers


class MainPresenter constructor(): MainContract.Presenter {

    private val disposable = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun releaseView() {
        disposable.clear()
    }

    @SuppressLint("CheckResult")
    override fun loadData() {
        println("load data")


        ApiProvider.provideGithubApi().getUser(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{ view.showProgress() }
            .doOnTerminate { view.hideProgress() }
            .subscribe({
                view.setItems(it.result as ArrayList<User>)
            },{

            }).addTo(disposable)
    }

    @SuppressLint("CheckResult")
    override fun evenetListen() {
        RxEvent.listen(LikeEvent::class.java).subscribe ({
            println("Listen event !! ")
            view.updateView(it.user)
        },{

        },{

        })
    }

}