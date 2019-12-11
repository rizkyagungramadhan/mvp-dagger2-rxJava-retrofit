package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jagungin.mvp_dagger2_rxjava_retrofit.R
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.component.DaggerFragmentComponent
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class AboutFragment: Fragment(), AboutContract.View {

    @Inject lateinit var presenter: AboutContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): AboutFragment {
        return AboutFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater?.inflate(R.layout.fragment_about, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    private fun initView() {
        presenter.loadMessage()
    }

    private fun injectDependency(){
        val aboutComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        aboutComponent.inject(this)
    }


    override fun showProgress(show: Boolean) {
        if(show){
            progressBar.visibility = View.VISIBLE
        } else{
            progressBar.visibility = View.GONE
        }
    }

    override fun loadMessageSuccess(message: String) {
        aboutText.text = getString(R.string.about_text)
        aboutText.visibility = View.VISIBLE
    }

    companion object{
        val TAG: String = "AboutFragment"
    }

}