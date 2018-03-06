package com.astimac.daggerexample.di

import com.astimac.daggerexample.MyApplication
import com.astimac.daggerexample.di.vm.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by astimac on 02.03.18..
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ActivityBuilder::class,
    NetworkModule::class
])
interface ApplicationComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApplication>()
}