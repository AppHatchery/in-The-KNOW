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
 * Use the [LoginScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var loginButton : Button = view.findViewById(R.id.signinbutton)
        loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_startDestination)
        }
        var createAccountButton : Button = view.findViewById(R.id.createAccountButton)
        createAccountButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_createAccount)
        }
    }


}