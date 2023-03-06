package com.amroid.dose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DoseApplication :Application() {
  override fun onCreate() {
    super.onCreate()

  }
}