package com.amroid.dose.data.repository

import android.util.Log
import com.amroid.dose.data.datasources.local.DrugDao
import com.amroid.dose.data.datasources.local.DrugEntity
import com.amroid.dose.data.datasources.remote.DiseaseApi
import com.amroid.dose.data.mappers.EntityMapper
import com.amroid.dose.data.mappers.NetworkMapper
import com.amroid.dose.data.model.DrugModel
import com.amroid.dose.data.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DiseaseRepository(
    private val api: DiseaseApi,
    private val dao: DrugDao,
    private val entityMapper: EntityMapper,
    private val networkMapper: NetworkMapper
) {
    public fun getDrugs(): Flow<Resource<List<DrugModel>>> = flow {
        try {
            emit(Resource.loading())


            try {
                val drugsList = networkMapper.toDrugList(api.getDisease())
                cacheDrugs(entityMapper.toEntityList(drugsList))
            } catch (e: Exception) {
                e.printStackTrace()
            }
            val cacheResult = getDrugsFromDb()
            val list = entityMapper.fromEntityList(cacheResult)

            emit(Resource.success(list))
        } catch (e: Exception) {
            Log.d("Error", "getDrugs: ")
            emit(Resource.error(e.message ?: "Unknown Error"))
        }
    }

    public fun getDrugById(drugId: Int): Flow<Resource<DrugModel>> = flow {
        try {
            emit(Resource.loading())

            val cacheResult = getDrug(drugId)
            val drugItem = entityMapper.mapToDomainModel(cacheResult)
            emit(Resource.success(drugItem))
        } catch (e: Exception) {
            emit(Resource.error(e.message ?: "Unknown Error"))
        }
    }

    public suspend fun cacheDrugs(drugEntityList: List<DrugEntity>) {
        dao.insertDrugs(drugEntityList)
    }

    public suspend fun getDrugsFromDb(): List<DrugEntity> {
        return dao.getAll()
    }

    public suspend fun getDrug(id: Int): DrugEntity {
        return dao.getDrug(id)
    }

}