package com.astimac.daggerexample.ui.main.fragments.fragment2

import android.util.Log
import com.astimac.daggerexample.ui.main.SomeComponent
import javax.inject.Inject

/**
 * Created by astimac on 02.03.18..
 */
class Fragment2Component @Inject constructor() : SomeComponent {
    override fun execute() {
        Log.e("DAGGER_EXAMPLE", "Fragment2Component")
    }
}