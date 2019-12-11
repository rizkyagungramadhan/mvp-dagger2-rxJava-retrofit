package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.main

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class MainPresenter : MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showListFragment() // as default
    }




}