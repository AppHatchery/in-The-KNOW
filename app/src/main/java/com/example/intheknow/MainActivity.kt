package com.example.intheknow

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.intheknow.databinding.ActivityMainBinding
import com.example.intheknow.ui.LoginScreen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginScreen.currMA = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController : NavController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
        var gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)



        //navController.navigate(R.id.action_startDestination_to_loginScreen)
        /*
        val firstFragment=StartDestination()
        val secondFragment=StartDestination()
        val thirdFragment=StartDestination()

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Home->setCurrentFragment(firstFragment)
                R.id.Chat->setCurrentFragment(secondFragment)
                R.id.Settings->setCurrentFragment(thirdFragment)
            }
            true
        }
         */


    }

    fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, 9001)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        LoginScreen.currLS.goHome()
        if (requestCode == 9001) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                LoginScreen.currLS.goHome()
                if (account != null) {

                }
                // Signed in successfully, show authenticated UI.

            } catch (e: ApiException) {
                // The ApiException status code indicates the detailed failure reason.
                // Please refer to the GoogleSignInStatusCodes class reference for more information.


            }
        }
    }

    override fun onStart() {
        super.onStart()
        LoginScreen.currMA = this
        val account = GoogleSignIn.getLastSignedInAccount(this)
        //Code for auto-login
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController : NavController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment,fragment)
            commit()
        }

}