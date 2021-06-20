package com.apphatchery.intheknow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [CreateEmoji.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateEmoji : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_emoji, container, false)
    }
    fun getEmoji(unicode: Int): String {
        return String(Character.toChars(unicode))
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val submitemoji = view.findViewById(R.id.submitemoji) as TextView
        val happy : Button = view.findViewById(R.id.happy)
        happy.text = getEmoji(0x1F60A)
        happy.setOnClickListener {
            submitemoji.text = getEmoji(0x1F60A)
        }
        val sunglass : Button = view.findViewById(R.id.sunglass)
        sunglass.text = getEmoji(0x1F60E)
        sunglass.setOnClickListener {
            submitemoji.text = getEmoji(0x1F60E)
        }
        val heart : Button = view.findViewById(R.id.heart)
        heart.text = getEmoji(0x1F970)
        heart.setOnClickListener {
            submitemoji.text = getEmoji(0x1F970)
        }
        val snooze : Button = view.findViewById(R.id.snooze)
        snooze.text = getEmoji(0x1F634)
        snooze.setOnClickListener {
            submitemoji.text = getEmoji(0x1F634)
        }
        val cry : Button = view.findViewById(R.id.cry)
        cry.text = getEmoji(0x1F622)
        cry.setOnClickListener {
            submitemoji.text = getEmoji(0x1F622)
        }
        val smash : Button = view.findViewById(R.id.smash)
        smash.text = getEmoji(0x1F624)
        smash.setOnClickListener {
            submitemoji.text = getEmoji(0x1F624)
        }
        val submit : Button = view.findViewById(R.id.submit)
        submit.setOnClickListener {
            findNavController().navigate(R.id.action_createEmoji_to_startDestination2)
        }
    }

}