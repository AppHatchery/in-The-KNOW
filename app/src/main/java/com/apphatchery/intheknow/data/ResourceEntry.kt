package com.apphatchery.intheknow.data

data class ResourceEntry (val title: String, val contents: String) {
    public fun getTheTitle(): String {
        return title
    }

    public fun getContent(): String {
        return contents
    }
}