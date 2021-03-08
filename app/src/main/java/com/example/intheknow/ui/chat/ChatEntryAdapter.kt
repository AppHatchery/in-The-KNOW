package com.example.intheknow.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intheknow.R
import com.example.intheknow.data.ChatEntry

class ChatEntryAdapter(
        private val chatList : List<ChatEntry>,
        private val listener : OnChatEntryClickListener
) : RecyclerView.Adapter<ChatEntryAdapter.ChatEntryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatEntryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row,
                parent, false)
        return ChatEntryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatEntryViewHolder, position: Int) {
        val currentItem = chatList[position]
        val question = currentItem.question
        val ppl = "Active People: " + currentItem.activePeople.toString()
        holder.questionsTV.text = question
        holder.numPplTV.text = ppl

    }

    override fun getItemCount() = chatList.size

    inner class ChatEntryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val questionsTV : TextView = itemView.findViewById(R.id.my_circle_question)
        val numPplTV : TextView = itemView.findViewById(R.id.my_circle_numppl)

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

    interface OnChatEntryClickListener {
        fun onChatEntryClick(position: Int, itemView : View)
    }


}