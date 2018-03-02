package com.astimac.daggerexample.ui.main.fragments.fragment1

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
class Fragment1 : BaseFragment() {

    @Inject
    lateinit var executor: ComponentExecutor

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        executor.execute()
    }
}