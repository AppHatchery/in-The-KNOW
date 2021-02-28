package com.example.intheknow

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_my_circle.*


/**
 * A simple [Fragment] subclass.
 * Use the [myCircle.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyCircle : Fragment(), ChatEntryAdapter.OnChatEntryClickListener {
    var load : Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_my_circle, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (load) {
            myCircleIO.putDefaultValues()
            myCircleIO.updateLocalData()

            myCircleIO.adapter.notifyItemRangeInserted(0, 4)
        }


        my_circle_roomsView.layoutManager = LinearLayoutManager(context)
        my_circle_roomsView.adapter = myCircleIO.adapter
        my_circle_roomsView.setHasFixedSize(true)

        if (load) {
            populateRandomChatData()
            Log.d("size of chat data", " " + myCircleIO.chatData.size)
            myCircleIO.adapter.notifyDataSetChanged()
        }

        load = false
    }

    private fun populateRandomChatData() {
        var exampleMessages : MutableList<Message> = mutableListOf<Message>()
        exampleMessages.add(Message("User 1", "Hi there, I am interested in safe sex practices. Any tips?"))
        exampleMessages.add(Message("User 2", "Same! What is your phone number?"))
        myCircleIO.chatData.add(ChatEntry("How to practice safe sex?", 12, exampleMessages)
        )
        myCircleIO.adapter.notifyItemInserted(4)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //super.onCreate(savedInstanceState)


        //val listView = view.findViewById<ListView>(R.id.listOfRooms)
        //val redColor = Color.parseColor("#FF0000")

        //listView.adapter = MyCustomAdapter(this)


      //  val newQuestion : Button = view.findViewById(R.id.new_question_btn)
      //  newQuestion.setOnClickListener {
       //     findNavController().navigate(R.id.action_myCircle_to_createNewChat)
       // }
       // val chatSelection : RecyclerView =  view.findViewById(R.id.chatroomRV)
       // chatSelection.setOnClickListener {
        //    findNavController().navigate(R.id.action_myCircle_to_communicationScreen)
       // }
    }

    override fun onChatEntryClick(position: Int, itemView: View) {
        myCircleIO.chatEntrySelector = position
        itemView.findNavController().navigate(R.id.action_myCircle_to_communicationScreen)
    }



    /** private class MyCustomAdapter(c: MyCircle, lis: ArrayList<ChatEntry>): ArrayAdapter<ChatEntry>() {
        val cont: MyCircle = c
        val liss: ArrayList<ChatEntry> = lis

        
        
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var listItemView = convertView
            if (listItemView == null) {
                listItemView = LayoutInflater.from(cont).inflate(R.layout.row, parent, false)
            }

            var curItem = getItem(position)
            var curName = listItemView.findViewById<TextView>(R.id.question)

            curName.setText(curItem.getTheQuestion())

            var num = listItemView.findViewById<TextView>(R.id.activePeople)

            num.setText(num.toString())

            return listItemView


        }



        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return 5
        }


    }*/

}