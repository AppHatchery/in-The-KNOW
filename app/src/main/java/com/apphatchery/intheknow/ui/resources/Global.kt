package com.apphatchery.intheknow.ui.resources

import android.app.Application

public class Global : Application() {
    companion object {
        @JvmField
        var newsContent: String = "defaultValue"
        var title: String = "defaultValue"
        var vidId: String = "36IBDpTRVNE"
        var vidTitle: String = "default"
    }
}