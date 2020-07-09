package com.example.toymvpgithubapi.data.api

import com.example.toymvpgithubapi.data.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface GithubApi{

    @GET("/")
    fun getUser(
        @Query("results") result:Int
    ): Observable<UserResponse>


//    @GET
//    fun getUserList(@Url url: String?): Observable<UserResponse?>?
}
