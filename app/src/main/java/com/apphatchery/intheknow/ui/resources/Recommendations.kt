package com.apphatchery.intheknow.ui.resources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apphatchery.intheknow.R


/**
 * A simple [Fragment] subclass.
 * Use the [Recommendations.newInstance] factory method to
 * create an instance of this fragment.
 */
class Recommendations : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommendations, container, false)
    }

}