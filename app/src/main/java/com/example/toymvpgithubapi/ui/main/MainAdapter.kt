package com.example.toymvpgithubapi.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.brandongogetap.stickyheaders.StickyLayoutManager
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler
import com.bumptech.glide.Glide
import com.example.toymvpgithubapi.R
import com.example.toymvpgithubapi.data.model.User
import kotlinx.android.synthetic.main.item_user_list.view.*


class MainAdapter constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

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




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == 0) CustomViewHolder(parent)
        else HeaderViewHolder(parent)
    }

    override fun getItemCount(): Int = this.collections.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is CustomViewHolder) {
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
                    cardView.tag = position
                }
            }
        }else if(holder is HeaderViewHolder){
            val data = collections[position]
            holder.apply {
                itemView.setOnClickListener {
                    onItemClick?.invoke(data)
                }
                with(data) {
                    with(name) {
                        tvName.text = first + last
                    }
                    tvLike.text = like.toString()
                    cardView.tag = position
                }
            }
        }

    }


    inner class CustomViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
    ) {
        val tvName: TextView = itemView.tv_name
        val ivThumb: ImageView = itemView.iv_thumb
        val tvLike: TextView = itemView.tv_like
        val cardView: CardView = itemView.cv_item
    }

    inner class HeaderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
    ) {
        val tvName: TextView = itemView.tv_name
        val tvLike: TextView = itemView.tv_like
        val cardView: CardView = itemView.cv_item
    }

    override fun getItemViewType(position: Int): Int {
        return collections[position].viewType
    }

//
//    override fun getHeaderPositionForItem(itemPosition: Int): Int {
//        var headerPosition = 0
//        var mItemPosition = itemPosition
//        do {
//            if(isHeader(mItemPosition)){
//                headerPosition = mItemPosition
//                break
//            }
//            mItemPosition -= 1
//        }while(mItemPosition >=0)
//        return headerPosition
//    }
//
//    override fun getHeaderLayout(headerPosition: Int): Int {
//        return if(collections[headerPosition].viewType == 1) R.layout.item_header
//        else R.layout.item_user_list
//    }
//
//    override fun bindHeaderData(header: View?, parent:ViewGroup,headerPosition: Int) {
//
//    }
//
//    override fun isHeader(itemPosition: Int): Boolean {
//        return collections[itemPosition].viewType == 1
//    }

//    override fun getAdapterData(): MutableList<*> {
//        return collections
//    }
}