package com.astimac.daggerexample.ui.main.fragments.fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.astimac.daggerexample.R
import com.astimac.daggerexample.ui.base.BaseFragment
import javax.inject.Inject

/**
 * Created by astimac on 02.03.18..
 */
class Fragment2 : BaseFragment() {

    @Inject
    lateinit var component: Fragment2Component

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_two, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        component.execute()
    }
}