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
 * Use the [podcasts.newInstance] factory method to
 * create an instance of this fragment.
 */
class podcasts : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_podcasts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var items = arrayOf<ResourceEntry>(ResourceEntry("pod1", "SwQhKFMxmDY"), ResourceEntry("pod2", "qksd7aHGAUQ"))

        var but1 : Button = view.findViewById(R.id.pod_but1)
        var but2 : Button = view.findViewById(R.id.pod_but2)

        but1.setText(items.get(0).title)
        but2.setText(items.get(1).title)

        but1.setOnClickListener {
            Global.vidId = items.get(0).contents
            Global.vidTitle = items.get(0).title
            findNavController().navigate(R.id.action_podcasts_to_podcastInfo)
        }

        but2.setOnClickListener {
            Global.vidId = items.get(1).contents
            Global.vidTitle = items.get(1).title
            findNavController().navigate(R.id.action_podcasts_to_podcastInfo)
        }






    }


}