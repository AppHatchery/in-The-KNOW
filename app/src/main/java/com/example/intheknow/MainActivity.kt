package com.example.intheknow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.intheknow.databinding.ActivityMainBinding
import com.example.intheknow.ui.StartDestination
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController : NavController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)

        //navController.navigate(R.id.action_startDestination_to_loginScreen)

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
    /*
    override fun onBackPressed() {
        val f: Fragment? = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (f is StartDestination) {

        } else if (f is MyLogger) {
            f.findNavController().navigate(R.id.action_myLogger_to_startDestination)
        } else if (f is MyLogEntries) {
            f.findNavController().navigate(R.id.action_myLogEntries_to_startDestination)
        } else if (f is MyLoggerEdit) {
            f.findNavController().navigate(R.id.action_myLoggerEdit_to_startDestination)
        } else {
            super.onBackPressed()
        }
    }
    */

}