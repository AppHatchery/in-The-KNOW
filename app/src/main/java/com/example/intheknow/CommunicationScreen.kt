package com.example.intheknow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_communication_screen.*
import kotlinx.android.synthetic.main.fragment_my_log_entries.*


/**
 * A simple [Fragment] subclass.
 * Use the [CommunicationScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommunicationScreen : Fragment() {
    private var messages : MutableList<Message> = mutableListOf<Message>()
    private val adapter : MessageAdapter = MessageAdapter(messages)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_communication_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view_chat.layoutManager = LinearLayoutManager(context)
        recycler_view_chat.adapter = adapter
        recycler_view_chat.setHasFixedSize(true)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message_list : MutableList<Message> = myCircleIO.chatData[myCircleIO.chatEntrySelector].chat
        for (m in message_list) {
            messages.add(m)
            adapter.notifyItemInserted(messages.size - 1)
        }

        val send_messg_btn : Button = view.findViewById(R.id.send_msg_btn)
        send_messg_btn.setOnClickListener {
            val m = view.findViewById<EditText>(R.id.editText_MSG).text.toString()
            messages.add(Message("UserX", m))
            adapter.notifyItemInserted(messages.size - 1)
        }

    }
}