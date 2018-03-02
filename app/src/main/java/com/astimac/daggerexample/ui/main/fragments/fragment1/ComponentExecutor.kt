package com.astimac.daggerexample.ui.main.fragments.fragment1

import com.astimac.daggerexample.ui.main.SomeComponent

/**
 * Created by astimac on 02.03.18..
 */
class ComponentExecutor(private val component: SomeComponent) {

    fun execute() {
        component.execute()
    }
}