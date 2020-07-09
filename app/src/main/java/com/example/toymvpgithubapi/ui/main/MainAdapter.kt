package com.example.toymvpgithubapi.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toymvpgithubapi.R
import com.example.toymvpgithubapi.data.model.User
import kotlinx.android.synthetic.main.item_user_list.view.*


class MainAdapter constructor() : RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {

    var collections: ArrayList<User> = ArrayList()
        set(value) {
            value.let {
                field = value
                this.notifyDataSetChanged()
            }
        }

    var onItemClick: ((item: User) -> Unit)? = null

    fun addItems(items: List<User>) {
        this.collections.plus(items)
        notifyDataSetChanged()
    }

    fun updateView(item: User) {
        val pos = getPosition(item)
        println(pos)
        if (pos == RecyclerView.NO_POSITION) return
        collections[pos] = item
        notifyDataSetChanged()
    }

    private fun getPosition(user: User) : Int{
        var pos = -1
        for(i in 0 until collections.size){
            if(collections[i].email == user.email) pos = i
        }
        return pos
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(parent)

    override fun getItemCount(): Int = this.collections.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val data = collections[position]
        holder.apply {
            itemView.setOnClickListener {
                onItemClick?.invoke(data)
            }
            with(data) {
                with(name) {
                    tvName.text = first + last
                }

                with(picture) {
                    Glide.with(itemView.context)
                        .load(large)
                        .into(ivThumb)
                }
                tvLike.text = like.toString()
            }
        }


    }


    inner class CustomViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
    ) {
        val tvName: TextView = itemView.tv_name
        val ivThumb: ImageView = itemView.iv_thumb
        val tvLike: TextView = itemView.tv_like
    }
}