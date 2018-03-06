package com.astimac.daggerexample.ui.base

import android.os.Bundle
import android.support.annotation.IdRes
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by astimac on 02.03.18..
 */
abstract class BaseActivity: DaggerAppCompatActivity() {

    fun replaceFragment(@IdRes containerId : Int, fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .commitAllowingStateLoss()
    }
}