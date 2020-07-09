package com.example.toymvpgithubapi.data.api

import com.example.toymvpgithubapi.data.const.Const
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiProvider {

    private const val CONNECT_TIMEOUT = 30L
    private const val WRITE_TIMEOUT = 30L
    private const val READ_TIMEOUT = 30L
    var baseUrl: String = Const.BASE_URL

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .addInterceptor(provideInterceptor())
            .build()
    }

    private fun provideInterceptor(): Interceptor {
        return Interceptor {
            val builder: Request.Builder = it.request().newBuilder()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Accept", "application/json; charset=utf-8")
            it.proceed(builder.build())
        }
    }


    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(provideOkHttpClient())
            .build()
    }

    fun provideGithubApi():GithubApi{
        return provideRetrofit().create(GithubApi::class.java)
    }


}
