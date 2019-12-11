package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.about


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class AboutPresenter : AboutContract.Presenter {

    //private val subscriptions = CompositeDisposable()
    private lateinit var view: AboutContract.View


    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attach(view: AboutContract.View) {
        this.view = view
    }

    override fun loadMessage() {
        //Wait a moment
        Observable.just(true).delay(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showProgress(false)
                view.loadMessageSuccess("Success")
            })
    }

}