package com.example.intheknow.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.intheknow.App
import com.example.intheknow.R
import com.example.intheknow.data.User
import com.example.intheknow.data.UserResolver
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton


/**
 * A simple [Fragment] subclass.
 * Use the [LoginScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        //val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        //if (account != null) {
        //    findNavController().navigate(R.id.action_loginScreen_to_createAccount)
        //}
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
        /*
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        view.findViewById<SignInButton>(R.id.sign_in_button_google).setOnClickListener {
            val signInIntent: Intent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }
         */
    }




}