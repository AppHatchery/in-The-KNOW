package com.apphatchery.intheknow.ui.resources

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.apphatchery.intheknow.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [podcastInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class podcastInfo : Fragment() {
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
        return inflater.inflate(R.layout.fragment_podcast_info, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment podcastInfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            podcastInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var titleText : TextView = view.findViewById(R.id.titleOfPod)
        var pod : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view)
        var pod2 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view2)
        var pod3 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view3)
        var pod4 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view4)
        var pod5 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view5)
        var pod6 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view6)
        var pod7 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view7)
        var pod8 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view8)
        var pod9 : androidx.cardview.widget.CardView = view.findViewById(R.id.pod_card_view9)
        //var contentText : TextView = view.findViewById(R.id.textOfNews)

        pod.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://therapyforblackgirls.com/podcast/")
            startActivity(openURL);
        }

        pod2.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.justdavia.com/podcast")
            startActivity(openURL);
        }


        pod3.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://podcasts.apple.com/us/podcast/between-sessions-podcast/id1345202684")
            startActivity(openURL);
        }

        pod4.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.celestethetherapist.com/")
            startActivity(openURL);
        }

        pod5.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.firefliesunite.com/podcast")
            startActivity(openURL);
        }

        pod6.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://talkingoffthecouch.com/")
            startActivity(openURL);
        }

        pod7.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://jennifersterling.com/podcast")
            startActivity(openURL);
        }

        pod8.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://jennifersterling.com/podcast")
            startActivity(openURL);
        }

        pod9.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://podcasts.apple.com/us/podcast/the-mindful-muslim-podcast/id1120442381")
            startActivity(openURL);
        }










    }
}