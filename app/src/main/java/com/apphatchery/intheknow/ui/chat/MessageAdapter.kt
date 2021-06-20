package com.apphatchery.intheknow.ui.chat


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apphatchery.intheknow.R
import com.apphatchery.intheknow.data.Message

class MessageAdapter(private val messageList : List<Message>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_1,
                parent, false)
        return MessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentItem = messageList[position]
        val name = currentItem.name
        val messg = currentItem.message
        holder.user.text = name
        holder.message.text = messg
    }

    override fun getItemCount() = messageList.size

    inner class MessageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val user : TextView = itemView.findViewById(R.id.message_user)
        val message : TextView = itemView.findViewById(R.id.message_text)


    }



}