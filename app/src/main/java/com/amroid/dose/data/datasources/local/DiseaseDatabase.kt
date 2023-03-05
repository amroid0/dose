package com.amroid.dose.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amroid.dose.data.model.DrugEntity

@Database(entities = [DrugEntity::class], version = 1)
abstract class DiseaseDatabase : RoomDatabase() {

    abstract fun userDao(): DrugDao
}