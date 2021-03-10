package com.example.intheknow.data

import java.util.*


data class User (
    val username : String,
    val password : String,
    val gender : String,
    val sexuality : String,
    val DOB : String,
    val firstName : String,
    val lastName : String
)


class UserResolver {
    //class is used to resolve the current user of the app
    //other features may assume user is resolved upon usage (call variable as UserResolver.____)
    companion object {
        var id : Long = 0
        var username : String = ""
        var firstName : String = ""
        var lastName : String = ""
        var gender : String = ""
        var sexuality : String = ""
        var DOB : String = ""
    }
}