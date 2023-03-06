package com.amroid.dose.repository

import com.amroid.dose.data.datasources.local.DrugDao
import com.amroid.dose.data.datasources.local.DrugEntity
import com.amroid.dose.data.datasources.remote.DiseaseApi
import com.amroid.dose.data.mappers.EntityMapper
import com.amroid.dose.data.mappers.NetworkMapper
import com.amroid.dose.data.model.DrugModel
import com.amroid.dose.data.model.Resource
import com.amroid.dose.data.repository.DiseaseRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class DiseaseRepositoryTest {

    @Mock
    lateinit var api: DiseaseApi

    @Mock
    lateinit var dao: DrugDao

    private lateinit var entityMapper: EntityMapper
    private lateinit var networkMapper: NetworkMapper

    private lateinit var repository: DiseaseRepository

    private val drugList = listOf(
        DrugModel(1, "Drug 1", "Description 1","200"),
        DrugModel(2, "Drug 2", "Description 2","300"),
        DrugModel(3, "Drug 3", "Description 3","500")
    )

    private val drugEntityList = listOf(
        DrugEntity( "Drug 1", "Description 1","200",1),
        DrugEntity( "Drug 2", "Description 2","300",2),
        DrugEntity( "Drug 3", "Description 3","500",3)
    )

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        entityMapper = EntityMapper()
        networkMapper = NetworkMapper()
        repository = DiseaseRepository(api, dao, entityMapper, networkMapper)
    }

    @Test
    fun `getDrugs returns correct list of drugs`() = runBlockingTest {
        `when`(dao.getAll()).thenReturn(drugEntityList)
        val result = repository.getDrugs().toList()
        assertEquals(Resource.success(drugList), result[1])
    }

    @Test
    fun `getDrugById returns correct Drug from cache`() = runBlockingTest {
        val drugId = 1
        val drugEntity = drugEntityList[1]
        val drugModel = drugList[1]
        `when`(dao.getDrug(drugId)).thenReturn(drugEntity)
        val result = repository.getDrugById(drugId).toList()
        assertEquals(Resource.success(drugModel), result[1])
    }

}
