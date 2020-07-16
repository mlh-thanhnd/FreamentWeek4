package com.example.fragmentactivityweek4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, ICommunicateFragment {
    private val fragmentManager: FragmentManager = supportFragmentManager
    private val listFragment = arrayListOf(NewsFeedFragment(), MessageFragment())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        leftBtn.setOnClickListener(this)
        rightBtn.setOnClickListener(this)
        showFragment(listFragment[0])
    }

    override fun onClick(v: View?) {
        when (v) {
            leftBtn -> {
                showFragment(listFragment[0])
            }
            rightBtn -> {
                showFragment(listFragment[1])
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
            listFragment.forEach {
                if (it != fragment) fragmentTransaction.hide(it)
            }
        } else {
            fragmentTransaction.add(R.id.containerFl, fragment)
        }
        fragmentTransaction.commit()
    }

    override fun doSomeThing(string: String) {
        when {
            listFragment[0].isVisible -> {
                showFragment(listFragment[1])
                (listFragment[1] as? MessageFragment)?.let {
                    it.list.add(string)
                    it.mAdapter?.setList(it.list)
                }
            }
        }
    }
}

interface ICommunicateFragment {
    fun doSomeThing(string: String)
}