package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.main

import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.base.BaseContract

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class MainContract {

    interface View: BaseContract.View{
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View>{
        fun onDrawerOptionAboutClick()
    }

}