package com.example.intheknow

import java.util.*

data class Event (val date : GregorianCalendar, val sexCategories: Set<Int>, val feelings: Set<Int>, val symptoms: Set<Int>, val log: String)