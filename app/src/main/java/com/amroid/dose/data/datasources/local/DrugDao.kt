package com.amroid.dose.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.amroid.dose.data.model.DrugEntity

@Dao
interface DrugDao {
    @Insert
    suspend fun insert(drug: DrugEntity)

    @Query("SELECT * FROM drugs")
    suspend fun getAll(): List<DrugEntity>
}
