package com.apphatchery.intheknow.ui.resources;

import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apphatchery.intheknow.R

import com.apphatchery.intheknow.data.ResourceEntry;

import java.util.List;

public class ResourceEntryAdapter(
        private val resList : List<ResourceEntry>,
        private val listener : OnResourceEntryClickListener ) :

        RecyclerView.Adapter<ResourceEntryAdapter.ResourceEntryViewHolder>(){



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceEntryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.row,
        parent, false)
        return ResourceEntryViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ResourceEntryViewHolder, position: Int) {
        val currentItem = resList[position]
        val title = currentItem.title
        val content = currentItem.contents

        holder.titleTV.text = title
        holder.contentTV.text = content

        }

        override fun getItemCount() = resList.size

        inner class ResourceEntryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

                val titleTV : TextView = itemView.findViewWithTag("Title")
                val contentTV : TextView = itemView.findViewWithTag("Content")

                init {
                        itemView.setOnClickListener(this)
                }

                override fun onClick(v: View?) {
                        val position : Int = adapterPosition
                        if (position != RecyclerView.NO_POSITION) {
                                if (v != null) {
                                        listener.onChatEntryClick(position, itemView)
                                }
                        }
                }
        }




    interface OnResourceEntryClickListener {
        fun onChatEntryClick(position: Int, itemView :View)
    }
}
