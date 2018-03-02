package com.astimac.daggerexample.ui.main

import com.astimac.daggerexample.ui.main.fragments.fragment1.Fragment1
import com.astimac.daggerexample.ui.main.fragments.fragment1.Fragment1Module
import com.astimac.daggerexample.ui.main.fragments.fragment2.Fragment2
import com.astimac.daggerexample.ui.main.fragments.fragment2.Fragment2Module
import com.astimac.daggerexample.ui.main.fragments.fragment3.Fragment3
import com.astimac.daggerexample.ui.main.fragments.fragment3.Fragment3Module
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by astimac on 02.03.18..
 */
@Module
abstract class MainFragmentsBuilder {

    @ContributesAndroidInjector(modules = [(Fragment1Module::class)])
    abstract fun bindFragment1() : Fragment1

    @ContributesAndroidInjector(modules = [(Fragment2Module::class)])
    abstract fun bindFragment2() : Fragment2

    @ContributesAndroidInjector(modules = [(Fragment3Module::class)])
    abstract fun bindFragment3() : Fragment3
}