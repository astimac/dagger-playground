package com.astimac.daggerexample.di

import android.content.Context
import com.astimac.daggerexample.MyApplication
import com.astimac.daggerexample.di.vm.ViewModelBuilder
import dagger.Module
import dagger.Provides

/**
 * Created by astimac on 02.03.18..
 */
@Module(includes = [ViewModelBuilder::class])
class ApplicationModule {

    @Provides
    fun provideContext(application: MyApplication): Context = application.applicationContext
}