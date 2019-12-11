package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jagungin.mvp_dagger2_rxjava_retrofit.R
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.component.DaggerFragmentComponent
import com.jagungin.mvp_dagger2_rxjava_retrofit.di.module.FragmentModule
import com.jagungin.mvp_dagger2_rxjava_retrofit.models.DetailsViewModel
import com.jagungin.mvp_dagger2_rxjava_retrofit.models.Post
import com.jagungin.mvp_dagger2_rxjava_retrofit.util.SwipeToDelete
import kotlinx.android.synthetic.main.fragment_about.progressBar
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class ListFragment : Fragment(), ListContract.View, ListAdapter.onItemClickListener {

    @Inject lateinit var presenter: ListContract.Presenter

    private lateinit var rootView: View

    fun newInstance(): ListFragment {
        return ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater?.inflate(R.layout.fragment_list, container, false)
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
        presenter.loadData()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        toast(error)
    }

    override fun loadDataSuccess(list: List<Post>) {
        var adapter = activity?.let { ListAdapter(it, list.toMutableList(), this) }
        recyclerView.layoutManager = (LinearLayoutManager(activity))
        recyclerView.adapter = adapter

        val swipeHandler = object : SwipeToDelete(activity!!.applicationContext){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerView.adapter as ListAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }

    override fun loadDataAllSuccess(model: DetailsViewModel) {
        println("oioi " + model.toJson())
    }

    override fun itemRemoveClick(post: Post) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun itemDetail(postId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toast(txt: String) {
        Toast.makeText(context, txt, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val TAG: String = "ListFragment"
    }

}