package com.astimac.daggerexample.di

import android.content.Context
import com.astimac.daggerexample.MyApplication
import dagger.Module
import dagger.Provides

/**
 * Created by astimac on 02.03.18..
 */
@Module
class ApplicationModule {

    @Provides
    fun provideContext(application: MyApplication): Context = application.applicationContext
}