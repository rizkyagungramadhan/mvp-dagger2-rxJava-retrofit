package com.jagungin.mvp_dagger2_rxjava_retrofit.di.component

import com.jagungin.mvp_dagger2_rxjava_retrofit.BaseApp
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.module.ApplicationModule
import dagger.Component

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
@Component (modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject (application: BaseApp)
}