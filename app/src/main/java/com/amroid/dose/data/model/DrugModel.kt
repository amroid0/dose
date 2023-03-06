package com.amroid.dose.data.model

import com.google.gson.annotations.SerializedName

data class DrugModel(
  val id:Int = 0,
  val name: String,
  val dose: String,
  val strength: String
)
