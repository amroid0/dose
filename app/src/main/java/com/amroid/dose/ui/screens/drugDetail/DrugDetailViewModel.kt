package com.amroid.dose.ui.screens.drugDetail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amroid.dose.data.model.DrugModel
import com.amroid.dose.data.repository.DiseaseRepository
import com.amroid.dose.utils.STATE_KEY_DRUG_ID
import com.amroid.dose.utils.STATE_KEY_NAME
import com.amroid.dose.utils.TimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DrugDetailViewModel @Inject constructor(
    private val repository: DiseaseRepository,
    private val stateHandle: SavedStateHandle
) : ViewModel() {
    val drug: MutableState<DrugModel?> = mutableStateOf(null)
    val loading = mutableStateOf(false)


    init {
        stateHandle.get<Int>(STATE_KEY_DRUG_ID)?.let { id ->
            getDrugDetail(id)

        }
    }


    private fun getDrugDetail(drugId: Int) {
        repository.getDrugById(drugId).onEach { dataState ->
            loading.value = dataState.loading
            dataState.data?.let { list ->
                drug.value = list
            }

            dataState.error?.let { error ->
                Log.e("Error", "newSearch: ${error}")
            }
        }.launchIn(viewModelScope)

    }

}