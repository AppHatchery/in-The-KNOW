package com.example.intheknow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        // Inflate the layout for this fragment
        val sampleQuestionList = listOf(
            ChatEntry("How to practice safe sex?", 12),
            ChatEntry("How is HIV transmitted", 6),
            ChatEntry("How do I know if it's too early to have sex?", 19),
            ChatEntry("How can I spruce up my sex life?", 30)
        )
        return inflater.inflate(R.layout.fragment_my_circle, container, false)
    }


}