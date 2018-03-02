package com.astimac.daggerexample.ui.main

import android.os.Bundle
import com.astimac.daggerexample.R
import com.astimac.daggerexample.ui.base.BaseActivity
import com.astimac.daggerexample.ui.main.fragments.fragment1.Fragment1
import com.astimac.daggerexample.ui.main.fragments.fragment2.Fragment2
import com.astimac.daggerexample.ui.main.fragments.fragment3.Fragment3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_fragment1 -> replaceFragment(R.id.fragment_container, Fragment1())
                R.id.action_fragment2 -> replaceFragment(R.id.fragment_container, Fragment2())
                R.id.action_fragment3 -> replaceFragment(R.id.fragment_container, Fragment3())
                else -> replaceFragment(R.id.fragment_container, Fragment1())
            }
            true
        }

        bottom_navigation.selectedItemId = R.id.action_fragment1
    }
}
