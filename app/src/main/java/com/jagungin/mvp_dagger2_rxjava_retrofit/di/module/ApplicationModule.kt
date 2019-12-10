package com.jagungin.mvp_dagger2_rxjava_retrofit.di.module

import android.app.Application
import com.jagungin.mvp_dagger2_rxjava_retrofit.BaseApp
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}