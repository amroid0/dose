package com.amroid.dose.data.repository

import com.amroid.dose.data.datasources.local.DrugDao
import com.amroid.dose.data.datasources.local.DrugEntity
import com.amroid.dose.data.datasources.remote.DiseaseApi
import com.amroid.dose.data.model.DrugModel
import kotlinx.coroutines.flow.Flow

class DiseaseRepository(private val api: DiseaseApi, private val dao: DrugDao) {
  public fun getDrugs(): Flow<List<DrugModel>>? {

    return null
  }

  public suspend fun cacheDrug(drugEntity: DrugEntity) {
    dao.insert(drugEntity)
  }

  public suspend fun getDrugsFromDb(): List<DrugEntity> {
    return dao.getAll()
  }

}