package com.jagungin.mvp_dagger2_rxjava_retrofit.di.component

import com.jagungin.mvp_dagger2_rxjava_retrofit.MainActivity
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.module.ActivityModule
import dagger.Component

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun injec(mainActivity: MainActivity)
}