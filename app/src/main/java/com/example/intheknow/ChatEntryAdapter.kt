package com.example.intheknow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.Month
import java.util.*
import kotlin.collections.HashMap

class ChatEntryAdapter(private val chatList : List<ChatEntry>) : RecyclerView.Adapter<ChatEntryAdapter.ChatEntryViewHolder>() {

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

    class ChatEntryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val questionsTV : TextView = itemView.findViewById(R.id.my_circle_question)
        val numPplTV : TextView = itemView.findViewById(R.id.my_circle_numppl)
    }

}