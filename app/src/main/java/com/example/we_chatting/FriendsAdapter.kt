package com.example.we_chatting

import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import android.widget.TextView
import android.widget.BaseAdapter


class FriendsAdapter(context: Context, list: List<Friends>, resourceId: Int) :
    BaseAdapter() {
    private val context: Context
    //定义数据源
    private val list: List<Friends>
    //定义布局资源Id
    private val resourceId: Int
    private var viewHolder: ViewHolder? = null
    override fun getCount(): Int {
        return list.size
    }
    // 获得某一位置的数据
    override fun getItem(position: Int): Any {
        return list[position]
    }
    //获得唯一标识
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View? {
        var view = view
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resourceId, null)
            viewHolder = ViewHolder()
            viewHolder!!.friendImage = view.findViewById<View>(R.id.image) as ImageView
            viewHolder!!.friendName = view.findViewById<View>(R.id.title) as TextView
            viewHolder!!.mButton  = view.findViewById<View>(R.id.delete_friends) as Button
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }
        viewHolder!!.friendImage!!.setImageResource(list[position].friendsimageId)
        viewHolder!!.friendName!!.text = list[position].friendsname
        viewHolder!!.mButton!!.setOnClickListener(View.OnClickListener {
            mOnItemDeleteListener?.onDeleteClick(
                position
            )
        })
        return view
    }

    /*
         删除好友的监听接口
         */
    interface onItemDeleteListener {
        fun onDeleteClick(position: Int)
    }

    private var mOnItemDeleteListener: onItemDeleteListener? = null

    fun setOnItemDeleteClickListener(mOnItemDeleteListener: onItemDeleteListener?) {
        this.mOnItemDeleteListener = mOnItemDeleteListener
    }

    internal inner class ViewHolder {
        var friendImage: ImageView? = null
        var friendName: TextView? = null
        var mButton: Button?=null
    }

    init {
        this.context = context
        this.list = list
        this.resourceId = resourceId
    }
}