package com.apphatchery.intheknow.ui

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
import com.apphatchery.intheknow.App
import com.apphatchery.intheknow.MainActivity
import com.apphatchery.intheknow.R
import com.apphatchery.intheknow.data.User
import com.apphatchery.intheknow.data.UserResolver
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


/**
 * A simple [Fragment] subclass.
 * Use the [LoginScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginScreen : Fragment() {

    companion object {
        var currMA : MainActivity = MainActivity()
        var currLS : LoginScreen = LoginScreen()
        var account : GoogleSignInAccount? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currLS = this
    }

    override fun onStart() {
        super.onStart()
        currLS = this
        //val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        //if (account != null) {
        //    findNavController().navigate(R.id.action_loginScreen_to_createAccount)
        //}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        currLS = this
        return inflater.inflate(R.layout.fragment_login_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //val drawer = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //drawer.isEnabled = false;
        currLS = this
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

        view.findViewById<SignInButton>(R.id.sign_in_button_google).setOnClickListener {
            currLS = this
            currMA.signIn()
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

    fun goHome() {
        findNavController().navigate(R.id.action_loginScreen_to_startDestination)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 9001) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                account = task.getResult(ApiException::class.java)

                if (account != null) {
                    //Set account to global variable and go from there
                    goHome()

                }
                // Signed in successfully, show authenticated UI.

            } catch (e: ApiException) {
                // The ApiException status code indicates the detailed failure reason.
                // Please refer to the GoogleSignInStatusCodes class reference for more information.


            }
        }
    }

}