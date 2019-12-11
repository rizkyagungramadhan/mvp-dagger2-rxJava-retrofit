package com.jagungin.mvp_dagger2_rxjava_retrofit.models

import com.google.gson.Gson

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
data class DetailsViewModel (val posts: List<Post>, val users: List<User>, val albums: List<Album>) {

    fun toJson(): String{
        return Gson().toJson(this)
    }
}