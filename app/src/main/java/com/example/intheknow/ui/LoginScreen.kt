package com.example.intheknow.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.intheknow.App
import com.example.intheknow.R
import com.example.intheknow.data.User
import com.example.intheknow.data.UserResolver


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
            val username : String = view.findViewById<EditText>(R.id.UsernameField).text.toString()
            val pwd : String = view.findViewById<EditText>(R.id.PasswordField).text.toString()
            val loginUser : User? = App.getDB().queryUserByUsername(username)
            val id : Long? = App.getDB().queryUserIDByUsername(username)
            if (loginUser != null && id != null && pwd == loginUser.password) {
                UserResolver.populateValues(id, loginUser)
                Log.d("Logging In", id.toString())
                findNavController().navigate(R.id.action_loginScreen_to_startDestination)
            }
        }
        var createAccountButton : Button = view.findViewById(R.id.createAccountButton)
        createAccountButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_createAccount)
        }
    }


}