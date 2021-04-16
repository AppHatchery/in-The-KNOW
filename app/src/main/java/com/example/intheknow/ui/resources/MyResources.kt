package com.example.intheknow.ui.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R


/**
 * A simple [Fragment] subclass.
 * Use the [MyResources.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyResources : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_resources, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var videosBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view)
        var currEventsBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view2)
        var newsFeedsBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view3)
        var podcastsBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view4)
        var supportGroupsBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view5)
        var recommendationsBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view6)
        var policiesBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view7)
        var mapBtn : androidx.cardview.widget.CardView = view.findViewById(R.id.card_view8)

        videosBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_videos2)
        }

        currEventsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_currentEvents)
        }
        newsFeedsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_newsfeed)
        }
        podcastsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_podcasts)
        }
        supportGroupsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_supportGroups)
        }
        recommendationsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_recommendations)
        }
        policiesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_policies2)
        }

        mapBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myResources_to_mapsFragment2)
        }

    }

}