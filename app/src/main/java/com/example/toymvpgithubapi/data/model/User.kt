package com.example.toymvpgithubapi.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User : Serializable{
    //name
    @SerializedName("name")
    val name:Name = Name()

    //gender
    @SerializedName("gender")
    val gender:String = ""

    //email
    @SerializedName("email")
    val email:String = ""
    //picture
    @SerializedName("picture")
    val picture:Picture = Picture()


    var like:Int = 0


    class Name : Serializable{
        @SerializedName("title")
        val title: String = ""
        @SerializedName("first")
        val first: String = ""
        @SerializedName("last")
        val last: String = ""
    }

    class Picture : Serializable{
        @SerializedName("large")
        val large:String = ""
        @SerializedName("medium")
        val medium:String = ""
        @SerializedName("thumbnail")
        val thumbnail:String = ""
    }

    override fun hashCode(): Int {
        return name.first.toInt()
    }
}