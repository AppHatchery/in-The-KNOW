package com.apphatchery.intheknow.ui.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.apphatchery.intheknow.R
import com.apphatchery.intheknow.data.ResourceEntry


/**
 * A simple [Fragment] subclass.
 * Use the [Newsfeed.newInstance] factory method to
 * create an instance of this fragment.
 */
class Newsfeed() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newsfeed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var items = arrayOf<ResourceEntry>(ResourceEntry("headline1", "content1"), ResourceEntry("headline2", "content2"))

        var but1 : Button = view.findViewById(R.id.news_but1)
        var but2 : Button = view.findViewById(R.id.news_but2)

        but1.setText(items.get(0).title)
        but2.setText(items.get(1).title)

        but1.setOnClickListener {
            Global.newsContent = items.get(0).contents
            Global.title = items.get(0).title
            findNavController().navigate(R.id.action_newsfeed_to_newsInfo)
        }

        but2.setOnClickListener {
            Global.newsContent = items.get(1).contents
            Global.title = items.get(1).title
            findNavController().navigate(R.id.action_newsfeed_to_newsInfo)
        }




    }

}