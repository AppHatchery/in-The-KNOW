package com.example.intheknow

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import android.icu.util.TimeUnit
import com.example.intheknow.data.DBHandler
import com.google.firebase.auth.EmailAuthProvider
import sdk.chat.app.firebase.ChatSDKFirebase
import sdk.chat.core.session.ChatSDK
import sdk.chat.firebase.adapter.module.FirebaseModule
import sdk.chat.firebase.push.FirebasePushModule
import sdk.chat.firebase.ui.FirebaseUIModule
import sdk.chat.firebase.upload.FirebaseUploadModule
import sdk.chat.ui.module.UIModule
import java.lang.Exception


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = DBHandler(applicationContext, null, null, 1)
        //Chat SDK initialization
        try {
            ChatSDKFirebase.quickStart(this, "pre_1", "failkey", true)
            /*
            ChatSDK.builder()
                .setGoogleMaps("failkey")
                .setPublicChatRoomLifetimeMinutes(2880)
                .build()
                .addModule(FirebaseModule.builder().setFirebaseRootPath("pre_1").build())
                .addModule(UIModule.shared())
                .addModule(FirebaseUploadModule.shared())
                .addModule(FirebasePushModule.shared())
                .addModule(FirebaseUIModule.builder().setProviders(EmailAuthProvider.PROVIDER_ID).build())
                .build()
                .activate(this, "intheknowdevelopment@gmail.com")
            */
        } catch (e : Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        var db: DBHandler? = null
        fun getDB(): DBHandler {
            return db!!
        }
    }
}