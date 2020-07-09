package com.example.toymvpgithubapi.ui.application.navigator

import android.content.Context
import android.content.Intent
import com.example.toymvpgithubapi.data.model.User
import com.example.toymvpgithubapi.ui.detail.DetailActivity


class Navigator {
    fun toDetail(context: Context?, user:User) {
        if (context != null) {
            val intentToLaunch = Intent(context, DetailActivity::class.java).apply {
                putExtra("User",user)
            }
            context.startActivity(intentToLaunch)
        }
    }
}