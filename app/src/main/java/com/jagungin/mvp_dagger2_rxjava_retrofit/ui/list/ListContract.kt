package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.list

import com.jagungin.mvp_dagger2_rxjava_retrofit.models.DetailsViewModel
import com.jagungin.mvp_dagger2_rxjava_retrofit.models.Post
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.base.BaseContract

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class ListContract {
    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Post>)
        fun loadDataAllSuccess(model: DetailsViewModel)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
        fun loadDataAll()
        fun deleteItem(item: Post)
    }
}