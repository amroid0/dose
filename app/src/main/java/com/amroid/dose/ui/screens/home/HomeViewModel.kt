package com.amroid.dose.ui.screens.home

import androidx.lifecycle.ViewModel
import com.amroid.dose.data.repository.DiseaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DiseaseRepository) : ViewModel() {
}