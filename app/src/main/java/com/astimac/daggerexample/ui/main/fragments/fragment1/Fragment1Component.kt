package com.astimac.daggerexample.ui.main.fragments.fragment1

import android.util.Log
import com.astimac.daggerexample.ui.main.SomeComponent

/**
 * Created by astimac on 02.03.18..
 */
class Fragment1Component : SomeComponent {

    override fun execute() {
        Log.e("DAGGER_EXAMPLE", "Fragment1Component")
    }
}