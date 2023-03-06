package com.amroid.dose.data.mappers

import com.amroid.dose.data.datasources.local.DrugEntity
import com.amroid.dose.data.model.DrugModel

class EntityMapper : Mapper<DrugEntity, DrugModel> {
    override fun mapToDomainModel(model: DrugEntity): DrugModel {
        return DrugModel(model.id, model.name, model.dose, model.strength)
    }

    override fun mapFromDomainModel(domainModel: DrugModel): DrugEntity {
        return DrugEntity(domainModel.name, domainModel.dose, domainModel.strength)

    }
    fun fromEntityList(initial: List<DrugEntity>): List<DrugModel>{
        return initial.map { mapToDomainModel(it) }
    }

    fun toEntityList(initial: List<DrugModel>): List<DrugEntity>{
        return initial.map { mapFromDomainModel(it) }
    }
}