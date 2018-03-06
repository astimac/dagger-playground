package com.astimac.daggerexample.di.vm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.astimac.daggerexample.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by astimac on 05.03.18..
 */
@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}