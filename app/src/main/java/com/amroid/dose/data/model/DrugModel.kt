package com.amroid.dose.data.model

import com.google.gson.annotations.SerializedName

data class DrugModel(
  val name: String,
  val dose: String,
  val strength: String
)
