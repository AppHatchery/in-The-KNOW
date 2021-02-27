package com.example.intheknow

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_my_circle.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [myCircle.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyCircle : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_my_circle, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sampleQuestionList = arrayListOf<ChatEntry>()
        sampleQuestionList.addAll(listOf(
                ChatEntry("How to practice safe sex?", 12),
                ChatEntry("How is HIV transmitted?", 6),
                ChatEntry("How do I know if it's too early to have sex?", 19),
                ChatEntry("How can I spruce up my sex life?", 30)
        ))

        my_circle_roomsView.layoutManager = LinearLayoutManager(context)
        my_circle_roomsView.adapter = ChatEntryAdapter(sampleQuestionList)
        my_circle_roomsView.setHasFixedSize(true)


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