package com.example.we_chatting

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*


class contact : Fragment() {

    val friendslist = ArrayList<Friends>()
    var listView: ListView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val page: View = inflater.inflate(R.layout.fragment_contact, container, false)

        listView = page.findViewById<View>(R.id.lv) as ListView
        //初始化
        initfriend()
        val adapter = getContext()?.let {
            FriendsAdapter(
                it, friendslist,
                R.layout.friends_item)
        }
        listView!!.adapter = adapter
        listView!!.setOnItemClickListener { parent, view, position, id ->
            val friend = friendslist[position]
            // Toast.makeText(getActivity(), fruit.friendsname ,Toast.LENGTH_SHORT).show()
            val alertdialogbuilder: AlertDialog.Builder = AlertDialog.Builder(getActivity())
            alertdialogbuilder.setMessage("您确认要与  " + friend.friendsname + "  聊天吗？")
            alertdialogbuilder.setPositiveButton("确定", null)
            alertdialogbuilder.setNeutralButton("取消", null)
            val alertdialog1: AlertDialog = alertdialogbuilder.create()
            alertdialog1.show()
        }
        //删除好友
        adapter!!.setOnItemDeleteClickListener(object : FriendsAdapter.onItemDeleteListener {
            override fun onDeleteClick(i: Int) {
                friendslist.removeAt(i)
                adapter.notifyDataSetChanged()
            }
        })
        return page
    }
    private fun initfriend() {
        repeat(2) {
            friendslist.add(Friends("卷王1", R.drawable.friend1))
            friendslist.add(Friends("卷王2", R.drawable.friend1))
            friendslist.add(Friends("卷王3", R.drawable.friend1))
            friendslist.add(Friends("卷王4", R.drawable.friend1))
            friendslist.add(Friends("卷王5", R.drawable.friend1))
            friendslist.add(Friends("卷王6", R.drawable.friend1))
            friendslist.add(Friends("卷王7", R.drawable.friend1))
            friendslist.add(Friends("卷王8", R.drawable.friend1))
            friendslist.add(Friends("卷王9", R.drawable.friend1))
            friendslist.add(Friends("卷王10", R.drawable.friend1))
            friendslist.add(Friends("卷王11", R.drawable.friend1))
            friendslist.add(Friends("卷王12", R.drawable.friend1))
        }
    }
}


