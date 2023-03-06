package com.amroid.dose.utils
import org.junit.Test
import org.junit.Assert.*

class TimeUtilsTestTest {

    @Test
    fun testGreeting() {

        val morningGreeting = TimeUtils.generateGreeting("Alice", 9)
        assertEquals("Good morning Alice!", morningGreeting)

        val afternoonGreeting = TimeUtils.generateGreeting("Bob", 14)
        assertEquals("Good afternoon Bob!", afternoonGreeting)

        val eveningGreeting = TimeUtils.generateGreeting("Charlie", 21)
        assertEquals("Good evening Charlie!", eveningGreeting)
    }
}