package com.amroid.dose.utils

import java.time.LocalTime
import java.util.*

object TimeUtils {
    fun sayGreeting(userName: String):String {
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good morning $userName!"
            in 12..16 -> "Good afternoon $userName!"
            else -> "Good evening $userName!"
        }
    }
}