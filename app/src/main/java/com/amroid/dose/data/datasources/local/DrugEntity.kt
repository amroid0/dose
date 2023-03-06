package com.amroid.dose.data.datasources.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drugs")
public data class DrugEntity(
    val name: String,
    val dose: String,
    val strength: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)