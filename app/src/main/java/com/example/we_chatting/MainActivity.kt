package com.example.we_chatting


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val mTab01: Fragment = message()
    private val mTab02: Fragment = contact()
    private val mTab03: Fragment = myinfo()

    private var mTabInfo: LinearLayout? = null
    private var mTabContact: LinearLayout? = null
    private var mTabMy: LinearLayout? = null

    private var mImgInfo: ImageButton? = null
    private var mImgContact: ImageButton? = null
    private var mImgMy: ImageButton? = null
    private var fm: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        setContentView(R.layout.activity_main)

        initFragment()
        initView()
        initEvent()
        selectFragment(0)

    }

    //添加界面
    private fun initFragment() {
        var fm = supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.add(R.id.content, mTab01)
        transaction.add(R.id.content, mTab02)
        transaction.add(R.id.content, mTab03)
        transaction.commit()
    }

    private fun resetImgs() {
        mImgInfo!!.setImageResource(R.drawable.message_unselected)
        mImgContact!!.setImageResource(R.drawable.friend_unselected)
        mImgMy!!.setImageResource(R.drawable.myinfo_unselected)
    }

    private fun initView() {
        mTabInfo = findViewById<View>(R.id.id_info_tab) as LinearLayout
        mTabContact = findViewById<View>(R.id.id_contact_tab) as LinearLayout
        mTabMy = findViewById<View>(R.id.id_my_tab) as LinearLayout

        mImgInfo = findViewById<View>(R.id.id_info_img) as ImageButton
        mImgContact = findViewById<View>(R.id.id_contact_img) as ImageButton
        mImgMy = findViewById<View>(R.id.id_my_img) as ImageButton
    }

    private fun selectFragment(i: Int) {
        var fm = supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()
        hideFragment(transaction)
        when (i) {
            0 -> {
                Log.d("setSelect", "1")
                transaction.show(mTab01)
                mImgInfo!!.setImageResource(R.drawable.message_selected)
            }
            1 -> {
                transaction.show(mTab02)
                mImgContact!!.setImageResource(R.drawable.friend_selected)
            }
            2 -> {
                transaction.show(mTab03)
                mImgMy!!.setImageResource(R.drawable.myinfo_selected)
            }
            else -> {
            }
        }
        transaction.commit()
    }

    private fun initEvent() {
        mTabInfo!!.setOnClickListener(this)
        mTabContact!!.setOnClickListener(this)
        mTabMy!!.setOnClickListener(this)
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        transaction.hide(mTab01)
        transaction.hide(mTab02)
        transaction.hide(mTab03)
    }

    override fun onClick(v: View) {
        Log.d("onClick", "1")
        resetImgs()
        when (v.id) {
            R.id.id_info_tab -> {
                Log.d("onClick", "2")
                selectFragment(0)
            }
            R.id.id_contact_tab -> selectFragment(1)
            R.id.id_my_tab -> selectFragment(2)
            else -> {
            }
        }
    }
}