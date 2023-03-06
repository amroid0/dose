package com.amroid.dose.di



import android.content.Context
import androidx.room.Room
import com.amroid.dose.data.datasources.local.DiseaseDatabase
import com.amroid.dose.data.datasources.local.DrugDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): DiseaseDatabase {
        return Room.databaseBuilder(context, DiseaseDatabase::class.java, "disease_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun drugDao(db: DiseaseDatabase): DrugDao = db.userDao()
}
