package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.jagungin.mvp_dagger2_rxjava_retrofit.R
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.component.DaggerActivityComponent
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.module.ActivityModule
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.about.AboutFragment
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.list.ListFragment
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }


    override fun showAboutFragment() {
        if(supportFragmentManager.findFragmentByTag(AboutFragment.TAG) == null){
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(AnimType.FADE.getAnimPair().first, AnimType.FADE.getAnimPair().second)
                .replace(R.id.frame, AboutFragment().newInstance(), AboutFragment.TAG)
        }
        else{
            // u can fill with shakehand and words like hello world
        }
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(AnimType.SLIDE.getAnimPair().first, AnimType.SLIDE.getAnimPair().second)
            .replace(R.id.frame, ListFragment().newInstance(), ListFragment.TAG)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_info -> {
                presenter.onDrawerOptionAboutClick()
                return true
            } else -> {}
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(AboutFragment.TAG)

        if(fragment == null){
            super.onBackPressed()
        } else{
            supportFragmentManager.popBackStack()
        }
    }

    private fun injectDependency(){
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    enum class AnimType(){
        SLIDE,
        FADE;

        fun getAnimPair(): Pair<Int, Int>{
            return when(this){
                SLIDE -> Pair(R.anim.slide_left, R.anim.slide_right)
                FADE -> Pair(R.anim.fade_in, R.anim.fade_out)
            }

        }
    }

}
