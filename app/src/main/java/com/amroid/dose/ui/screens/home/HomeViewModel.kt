package com.amroid.dose.ui.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amroid.dose.data.model.DrugModel
import com.amroid.dose.data.repository.DiseaseRepository
import com.amroid.dose.utils.STATE_KEY_NAME
import com.amroid.dose.utils.TimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DiseaseRepository,
    private val stateHandle: SavedStateHandle
) : ViewModel() {
    val greetingMsg = mutableStateOf("")
    val drugs: MutableState<List<DrugModel>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)


    init {
        stateHandle.get<String>(STATE_KEY_NAME)?.let { name ->
            greetingMsg.value = TimeUtils.sayGreeting(name)
        }
        loadDrugs()
    }

    private fun loadDrugs() {
        repository.getDrugs().onEach { dataState ->
            loading.value = dataState.loading

            dataState.data?.let { list ->
                drugs.value = list
            }

            dataState.error?.let { error ->
                Log.e("Error", "newSearch: ${error}")
            }
        }.launchIn(viewModelScope)

    }

}