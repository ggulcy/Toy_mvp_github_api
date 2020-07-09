package com.example.toymvpgithubapi.ui.application.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity(){


    @Override
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }


}