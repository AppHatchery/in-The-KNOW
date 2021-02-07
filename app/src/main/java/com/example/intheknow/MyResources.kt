package com.example.intheknow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyResources.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyResources : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyResources.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyResources().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}