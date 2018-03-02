package com.astimac.daggerexample.ui.main.fragments.fragment1

import dagger.Module
import dagger.Provides

/**
 * Created by astimac on 02.03.18..
 */
@Module
class Fragment1Module {

    @Provides
    fun provideComponent() = Fragment1Component()

    @Provides
    fun provideExecutor(component: Fragment1Component) = ComponentExecutor(component)
}