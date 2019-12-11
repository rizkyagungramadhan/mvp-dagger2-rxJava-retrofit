package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.base

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
class BaseContract {

    interface Presenter<in T>{
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View{

    }
}