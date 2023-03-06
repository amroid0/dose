package com.amroid.dose.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DrugDao {
    @Insert
    suspend fun insert(drug: DrugEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrugs(recipes: List<DrugEntity>): LongArray

    @Query("SELECT * FROM drugs")
    suspend fun getAll(): List<DrugEntity>

    @Query("SELECT * FROM drugs  WHERE id = :id")
    suspend fun getDrug(id: Int): DrugEntity
    @Query("DELETE FROM drugs")
    suspend fun deleteAllDrugs()
}
