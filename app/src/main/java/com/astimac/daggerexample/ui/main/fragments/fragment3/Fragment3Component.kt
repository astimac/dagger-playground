package com.astimac.daggerexample.ui.main.fragments.fragment3

import android.util.Log
import com.astimac.daggerexample.ui.main.SomeComponent
import javax.inject.Inject

/**
 * Created by astimac on 02.03.18..
 */
class Fragment3Component @Inject constructor() : SomeComponent {
    override fun execute() {
        Log.e("DAGGER_EXAMPLE", "Fragment3Component")
    }
}