package com.jagungin.mvp_dagger2_rxjava_retrofit.di.module

import android.app.Activity
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.main.MainContract
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
@Module
class ActivityModule (private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter{
        return MainPresenter()
    }
}