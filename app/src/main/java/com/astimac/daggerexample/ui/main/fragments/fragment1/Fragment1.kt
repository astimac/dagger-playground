package com.astimac.daggerexample.ui.main.fragments.fragment1

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.astimac.daggerexample.R
import com.astimac.daggerexample.data.api.response.PopularMovie
import com.astimac.daggerexample.ui.base.BaseFragment
import com.astimac.daggerexample.ui.main.MainActivityViewModel
import javax.inject.Inject

/**
 * Created by astimac on 02.03.18..
 */
class Fragment1 : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity, viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.popularMovies.observe(this, Observer {log1(it)})
    }

    private fun log1(list: List<PopularMovie>?) {
        for (it in list!!) {
            Log.e("Tag", it.toString())
        }
    }
}