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
        var videosBtn : Button = view.findViewById(R.id.Videos)
        var currEventsBtn : Button = view.findViewById(R.id.CurrentEvents)
        var newsFeedsBtn : Button = view.findViewById(R.id.Newsfeeds)
        var podcastsBtn : Button = view.findViewById(R.id.Podcasts)
        var supportGroupsBtn : Button = view.findViewById(R.id.SupportGroups)
        var recommendationsBtn : Button = view.findViewById(R.id.recommendations_button)
        var policiesBtn : Button = view.findViewById(R.id.policies_button)
        var mapBtn : Button = view.findViewById(R.id.mapBtn)

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