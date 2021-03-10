package com.example.intheknow.ui

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
 * Use the [CreateAccount.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateAccount : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var submitAccountButton : Button = view.findViewById(R.id.createNewAccountSubmit)
        submitAccountButton.setOnClickListener {
            //db add user

            findNavController().navigate(R.id.action_createAccount_to_startDestination)
        }
    }
}