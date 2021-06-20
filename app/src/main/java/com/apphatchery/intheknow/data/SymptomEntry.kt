package com.apphatchery.intheknow.data

import java.util.*

data class SymptomEntry (
    var dateOfEntry : GregorianCalendar,
    var symptoms: List<String>
) {
    companion object {
        //define symptoms
        val MISSED_PERIOD = "missed period"
        val VAGINAL_ITCHING = "vaginal itching"
        val VAGINAL_BURNING = "vaginal burning"
        val VAGINAL_ODOR = "vaginal odor"
        val VAGINAL_DISCHARGE = "vaginal discharge"
        val PAIN = "pain during intercourse"
        val BLEEDING = "abnormal vaginal bleeding"
        val FEVER = "fever"
        val RASHES = "skin changes/rashes"
        val AB_PAIN = "lower abdominal pain"
    }
}
