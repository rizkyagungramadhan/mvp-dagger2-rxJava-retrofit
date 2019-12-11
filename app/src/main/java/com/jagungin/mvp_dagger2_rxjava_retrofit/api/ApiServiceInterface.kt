package com.jagungin.mvp_dagger2_rxjava_retrofit.api

import com.jagungin.mvp_dagger2_rxjava_retrofit.models.Album
import com.jagungin.mvp_dagger2_rxjava_retrofit.models.Post
import com.jagungin.mvp_dagger2_rxjava_retrofit.models.User
import com.jagungin.mvp_dagger2_rxjava_retrofit.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
interface ApiServiceInterface {

    @GET("albums")
    fun getAlbumList(): Observable<List<Album>>

    @GET("albums/{id}")
    fun getAlbum(@Path("id") id: Int): Observable<Album>

    @DELETE("albums/{id}")
    fun deleteAlbum(@Path("id" ) id: Int)

    @GET("posts")
    fun getPostList(): Observable<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Observable<List<Post>>

    @DELETE("albums/{id}")
    fun deletePost(@Path("id") id: Int)

    @GET("posts/{id}")
    fun getUser(@Path("id") id: Int) : Observable<User>

    @GET("users")
    fun getUserList(): Observable<List<User>>

    @DELETE("albums/{id}")
    fun deleteUser(@Path("id") id: Int)

    companion object Factory{
        fun create(): ApiServiceInterface{
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }



}