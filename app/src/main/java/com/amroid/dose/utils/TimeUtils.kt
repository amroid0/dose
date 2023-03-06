package com.amroid.dose.utils

import java.time.LocalTime
import java.util.*

object TimeUtils {
    fun generateGreeting(userName: String, hourOfDay: Int): String {
        return when (hourOfDay) {
            in 0..11 -> "Good morning $userName!"
            in 12..16 -> "Good afternoon $userName!"
            else -> "Good evening $userName!"
        }
    }

    fun getCurrentHourOfDay(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.HOUR_OF_DAY)
    }
}