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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CurrentEvents.newInstance] factory method to
 * create an instance of this fragment.
 */
class CurrentEvents : Fragment() {
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
        return inflater.inflate(R.layout.fragment_current_events, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CurrentEvents.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CurrentEvents().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var items = arrayOf<ResourceEntry>(ResourceEntry("ev1", "content1"), ResourceEntry("ev2", "content2"))

        var but1 : Button = view.findViewById(R.id.curr_but1)
        var but2 : Button = view.findViewById(R.id.curr_but2)

        but1.setText(items.get(0).title)
        but2.setText(items.get(1).title)

        but1.setOnClickListener {
            Global.newsContent = items.get(0).contents
            Global.title = items.get(0).title
            findNavController().navigate(R.id.action_currentEvents_to_currEventsInfo)
        }

        but2.setOnClickListener {
            Global.newsContent = items.get(1).contents
            Global.title = items.get(1).title
            findNavController().navigate(R.id.action_currentEvents_to_currEventsInfo)
        }



    }
}