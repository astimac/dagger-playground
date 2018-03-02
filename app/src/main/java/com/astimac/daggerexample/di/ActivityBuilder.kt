package com.astimac.daggerexample.di

import com.astimac.daggerexample.ui.main.MainActivity
import com.astimac.daggerexample.ui.main.MainActivityModule
import com.astimac.daggerexample.ui.main.MainFragmentsBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by astimac on 02.03.18..
 *
 * Maps all activities here
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        MainFragmentsBuilder::class
    ])
    abstract fun bindMainActivity() : MainActivity

}