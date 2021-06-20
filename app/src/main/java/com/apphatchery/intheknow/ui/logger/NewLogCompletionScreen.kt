package com.apphatchery.intheknow.ui.logger

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.apphatchery.intheknow.R
import com.apphatchery.intheknow.databinding.FragmentNewLogCompletionScreenBinding


/**
 * A simple [Fragment] subclass.
 * Use the [NewLogCompletionScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewLogCompletionScreen : Fragment() {
    lateinit var binding: FragmentNewLogCompletionScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_log_completion_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val done : ImageView = binding.doneCheck
        val drawable : Drawable = done.drawable
        if (drawable is AnimatedVectorDrawableCompat) {
            val avd = drawable as AnimatedVectorDrawableCompat
            avd.start()
            while(avd.isRunning()) {
            }
        } else if (drawable is AnimatedVectorDrawable) {
            val avd = drawable as AnimatedVectorDrawable
            avd.start()
            while(avd.isRunning()) {
            }
        }

        val loggedText : TextView = binding.LoggedText
        val resBtn : Button = binding.seeResourcesUponCompleteLog

        loggedText.isVisible = true
        resBtn.isVisible = true

        resBtn.setOnClickListener {
            findNavController().navigate(R.id.action_newLogCompletionScreen_to_myResources)
        }



    }

}