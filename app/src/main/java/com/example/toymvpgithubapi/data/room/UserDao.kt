package com.example.toymvpgithubapi.data.room

import androidx.room.*
import com.example.toymvpgithubapi.data.model.User
import io.reactivex.Flowable


@Dao
interface UserDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(user: User)


    @Update
    fun update(user:User)

    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM userTable")
    fun getUser():Flowable<List<User>>

    @Query("DELETE FROM userTable")
    fun clearAll()
}