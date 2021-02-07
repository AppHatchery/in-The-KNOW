package com.example.intheknow

import android.view.View
import android.widget.TextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class MyCircleRVViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val questionTV : TextView = view.findViewById(R.id.my_circle_question_tv)
    val numpplTV : TextView = view.findViewById(R.id.my_circle_numppl_tv)

    fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
        object: ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int = adapterPosition
            override fun getSelectionKey(): Long? = itemId
        }
}