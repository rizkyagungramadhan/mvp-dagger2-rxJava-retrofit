package com.jagungin.mvp_dagger2_rxjava_retrofit.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.jagungin.mvp_dagger2_rxjava_retrofit.R

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 10/12/2019.
 */
abstract class SwipeToDelete(context: Context) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    private val deleteIcon = ContextCompat.getDrawable(context, R.drawable.ic_del)
    private val intrinsicWidth = deleteIcon?.intrinsicWidth
    private val intrinsicHeight = deleteIcon?.intrinsicHeight


    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        //no need to implement drag & drop
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val itemView = viewHolder?.itemView
        val itemHeight = itemView.bottom - itemView.top

        val background = ColorDrawable()
        background.color = Color.parseColor("#801515")
        background.setBounds(itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
        background.draw(c)

        val deleteIconTop = intrinsicHeight?.let { itemView.top + (itemHeight - it) / 2 }
        val deleteIconMargin = intrinsicHeight?.let { (itemHeight - it) / 2 }
        val deleteIconLeft = intrinsicWidth?.let { itemView.right - deleteIconMargin!! - it }
        val deleteIconRight = deleteIconMargin?.let { itemView.right - it }
        val deleteIconBottom = intrinsicHeight?.let{ deleteIconTop!! + it }

        deleteIcon?.setBounds(deleteIconLeft!!, deleteIconTop!!, deleteIconRight!!, deleteIconBottom!!)
        deleteIcon?.draw(c)
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}
