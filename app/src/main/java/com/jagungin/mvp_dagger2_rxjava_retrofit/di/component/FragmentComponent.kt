package com.jagungin.mvp_dagger2_rxjava_retrofit.di.component

import androidx.fragment.app.ListFragment
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.module.FragmentModule
import dagger.Component

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(aboutFragment: AboutFragment)

    fun inject(listFragment: ListFragment)
}