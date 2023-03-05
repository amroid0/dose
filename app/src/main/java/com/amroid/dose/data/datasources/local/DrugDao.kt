package com.amroid.dose.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.amroid.dose.data.model.Drug

@Dao
interface DrugDao {
    @Insert
    suspend fun insert(drug: Drug)

    @Query("SELECT * FROM drugs")
    suspend fun getAll(): List<Drug>
}
