package com.jagungin.mvp_dagger2_rxjava_retrofit.di.module

import com.jagungin.mvp_dagger2_rxjava_retrofit.api.ApiServiceInterface
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.about.AboutContract
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.about.AboutPresenter
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.list.ListContract
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
@Module
class FragmentModule {

    @Provides
    fun provideAboutPresenter(): AboutContract.Presenter {
        return AboutPresenter()
    }

    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}