package com.example.toymvpgithubapi.data.model

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "userTable")
class User : Serializable{
    //name
    @Embedded
    @SerializedName("name")
    var name:Name = Name()

    //gender
    @Embedded
    @SerializedName("gender")
    var gender:String = ""

    //email
    @PrimaryKey
    @NonNull
    @SerializedName("email")
    var email:String = ""

    //picture
    @Embedded
    @SerializedName("picture")
    var picture:Picture = Picture()


    var like:Int = 0


    class Name : Serializable{
        @SerializedName("title")
        var title: String = ""
        @SerializedName("first")
        var first: String = ""
        @SerializedName("last")
        var last: String = ""
    }

    class Picture : Serializable{
        @SerializedName("large")
        var large:String = ""
        @SerializedName("medium")
        var medium:String = ""
        @SerializedName("thumbnail")
        var thumbnail:String = ""
    }

    override fun hashCode(): Int {
        return name.first.toInt()
    }
}