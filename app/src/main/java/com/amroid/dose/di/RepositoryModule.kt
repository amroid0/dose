package com.amroid.dose.di
import com.amroid.dose.data.datasources.local.DrugDao
import com.amroid.dose.data.datasources.remote.DiseaseApi
import com.amroid.dose.data.repository.DiseaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

  @Singleton
  @Provides
  fun provideDiseaseRepository(diseaseApi: DiseaseApi, dao: DrugDao): DiseaseRepository {
    return DiseaseRepository(diseaseApi, dao)
  }

}
