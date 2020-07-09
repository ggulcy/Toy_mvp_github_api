package com.example.toymvpgithubapi.ui

import com.example.toymvpgithubapi.data.model.User
import io.reactivex.subjects.PublishSubject


object RxEvent {
    private val publisher = PublishSubject.create<Any>()

    fun sendEvent(event: Any){
        publisher.onNext(event)
    }
    fun <T> listen(eventType: Class<T>) = publisher.ofType(eventType)
}


class LikeEvent(val user: User)

