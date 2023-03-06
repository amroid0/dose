package com.amroid.dose.utils

import android.content.res.Resources

val Int.dp: Int
  get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Float.px: Int
  get() = (this * Resources.getSystem().displayMetrics.density).toInt()
const val STATE_KEY_NAME ="name"
const val STATE_KEY_DRUG_ID ="drug_id"