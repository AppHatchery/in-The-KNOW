package com.apphatchery.intheknow

import android.app.Application
import com.apphatchery.intheknow.data.DBHandler
import sdk.chat.app.firebase.ChatSDKFirebase
import java.lang.Exception


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = DBHandler(applicationContext, null, null, 2)
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