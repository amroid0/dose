package com.amroid.dose.data.mappers

import com.amroid.dose.data.datasources.remote.DiseaseResponse
import com.amroid.dose.data.datasources.remote.Drug
import com.amroid.dose.data.model.DrugModel

class NetworkMapper : Mapper<Drug, DrugModel> {
    override fun mapToDomainModel(model: Drug): DrugModel {
        return DrugModel(name = model.name, dose = model.dose, strength = model.strength)
    }

    override fun mapFromDomainModel(domainModel: DrugModel): Drug {
        return Drug(domainModel.name, domainModel.dose, domainModel.strength)

    }

    fun fromNetworkList(initial: List<Drug>): List<DrugModel> {
        return initial.map { mapToDomainModel(it) }
    }

    fun toNetworkList(initial: List<DrugModel>): List<Drug> {
        return initial.map { mapFromDomainModel(it) }
    }

    fun toDrugList(diseaseResponse: DiseaseResponse): List<DrugModel> {
        val drugs = mutableListOf<DrugModel>()
        diseaseResponse.problems.forEach {

            it.diabetes.forEach { diabetes ->
                diabetes.medications.forEach { medication ->
                    medication.medicationClasses.forEach { medicationClass ->
                        medicationClass.className.forEach { associatedDrug ->
                            drugs.addAll(fromNetworkList(associatedDrug.associatedDrug))
                            drugs.addAll(fromNetworkList(associatedDrug.associatedDrug2))

                        }
                        medicationClass.className2.forEach { associatedDrug ->
                            drugs.addAll(fromNetworkList(associatedDrug.associatedDrug))
                            drugs.addAll(fromNetworkList(associatedDrug.associatedDrug2))
                        }
                    }
                }
            }
        }
        return drugs.toList()
    }
}