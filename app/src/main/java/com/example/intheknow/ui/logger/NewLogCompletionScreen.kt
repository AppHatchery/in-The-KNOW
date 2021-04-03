package com.example.intheknow.ui.logger

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.intheknow.R



/**
 * A simple [Fragment] subclass.
 * Use the [NewLogCompletionScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewLogCompletionScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_log_completion_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val done : ImageView = view.findViewById(R.id.doneCheck)
        val drawable : Drawable = done.drawable
        if (drawable is AnimatedVectorDrawableCompat) {
            val avd = drawable as AnimatedVectorDrawableCompat
            avd.start()
        } else if (drawable is AnimatedVectorDrawable) {
            val avd = drawable as AnimatedVectorDrawable
            avd.start()
        }

    }

}