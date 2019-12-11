package com.jagungin.mvp_dagger2_rxjava_retrofit.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.jagungin.mvp_dagger2_rxjava_retrofit.R
import com.jagungin.mvp_dagger2_rxjava_retrofit.models.Post
import com.jagungin.mvp_dagger2_rxjava_retrofit.ui.about.AboutContract
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 11/12/2019.
 */
class ListAdapter(private val context: Context, private val list: MutableList<Post>,
                  fragment: Fragment): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val listener: ListAdapter.onItemClickListener
    init {
        this.listener = fragment as ListAdapter.onItemClickListener
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var post = list[position]

        //holder?.bind(post)
        holder.title.text = post.title
        holder.body.text = post.body

        holder.layout.setOnClickListener {
            listener.itemDetail(post.id.toString())
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ListAdapter.ListViewHolder(itemView)
    }

    interface onItemClickListener {
        fun itemRemoveClick(post: Post)
        fun itemDetail(postId: String)
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var layout = itemView.findViewById<ConstraintLayout>(R.id.item_layout)
        val title = itemView.findViewById<TextView>(R.id.item_title)
        val body = itemView.findViewById<TextView>(R.id.item_body)

        /*fun bind(item: Post){
            //title = item.post
            //body blablabla
        }*/

    }

    fun removeAt(position: Int){
        list.removeAt(position)
        notifyItemRemoved(position)
    }
}