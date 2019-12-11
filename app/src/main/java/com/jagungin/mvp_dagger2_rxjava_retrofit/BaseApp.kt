package com.jagungin.mvp_dagger2_rxjava_retrofit

import android.app.Application
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.component.ApplicationComponent
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.component.DaggerApplicationComponent
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.module.ApplicationModule
import okhttp3.internal.Internal.instance

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if(BuildConfig.DEBUG){
            //maybe timberplant etc
        }
    }

    private fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
    component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent{
        return component
    }

    companion object{
        lateinit var instance: BaseApp private set
    }
}