package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.about

import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.base.BaseContract

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class AboutContract {

    interface View: BaseContract.View{
        fun showProgress(show: Boolean)
        fun loadMessageSuccess(message: String)
        //fun loadMessageError() //if u are using ur real backend, not typicode or something else
    }

    interface Presenter: BaseContract.Presenter<View>{
        fun loadMessage() //assume that, this will be a retrofit request
    }
}