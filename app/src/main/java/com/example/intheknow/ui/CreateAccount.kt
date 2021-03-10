package com.example.intheknow.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.intheknow.R
import com.example.intheknow.data.DBHandler
import com.example.intheknow.data.User
import com.example.intheknow.data.UserResolver


/**
 * A simple [Fragment] subclass.
 * Use the [CreateAccount.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateAccount : Fragment() {
    val db by lazy {DBHandler(requireContext(), null, null, 1)}

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
            val username : String = view.findViewById<EditText>(R.id.UserNameEditText).text.toString()
            val password : String = view.findViewById<EditText>(R.id.PwdEditText).text.toString()
            val gender : String = view.findViewById<Spinner>(R.id.gender_spinner).selectedItem.toString()
            val sexuality : String = view.findViewById<Spinner>(R.id.sexuality_spinner).selectedItem.toString()
            val firstName : String = view.findViewById<EditText>(R.id.FirstNameEditText).text.toString()
            val lastName : String = view.findViewById<EditText>(R.id.LastNameEditText).text.toString()
            val date : DatePicker = view.findViewById<DatePicker>(R.id.date_of_birth_picker)
            val year : String = date.year.toString()
            val day : String = date.dayOfMonth.toString()
            val month : String = (1 + date.month).toString()
            val dateStr : String = month + "/" + day + "/" + year
            val newUser : User = User(username, password, gender, sexuality, dateStr, firstName, lastName)
            val id : Long = db.addUser(newUser)

            //populate user resolver for app features
            UserResolver.id = id
            UserResolver.username = username
            UserResolver.firstName = firstName
            UserResolver.lastName = lastName
            UserResolver.gender = gender
            UserResolver.sexuality = sexuality
            UserResolver.DOB = dateStr


            Log.i("DB", id.toString())
            //Test Query
            /*
            val testUser : User? = db.queryUserByUsename("ajones")
            if (testUser != null) {
                Log.i("DB Query", testUser.firstName)
            } else {
                Log.i("DB Query", "Failed")
            }
            */

            findNavController().navigate(R.id.action_createAccount_to_startDestination)
        }
    }
}