package com.apphatchery.intheknow.ui.resources

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apphatchery.intheknow.R


/**
 * A simple [Fragment] subclass.
 * Use the [SupportGroups.newInstance] factory method to
 * create an instance of this fragment.
 */
class SupportGroups : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_support_groups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //var titleText : TextView = view.findViewById(R.id.titleOfPod)
        var pod : androidx.cardview.widget.CardView = view.findViewById(R.id.sup_card_view)

        //var contentText : TextView = view.findViewById(R.id.textOfNews)

        pod.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://providers.therapyforblackgirls.com/")
            startActivity(openURL);
        }




    }


}