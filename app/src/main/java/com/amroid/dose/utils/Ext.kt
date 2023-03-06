package com.amroid.dose.utils

import android.content.res.Resources

val Int.dp: Int
  get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Float.px: Int
  get() = (this * Resources.getSystem().displayMetrics.density).toInt()