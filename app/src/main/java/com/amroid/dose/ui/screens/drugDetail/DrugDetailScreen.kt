package com.amroid.dose.ui.screens.drugDetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amroid.dose.navigation.NavRoutes
import com.amroid.dose.ui.component.DrugCard
import com.amroid.dose.ui.component.DrugList
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun DrugDetailScreen(
    navController: NavHostController,
    viewModel: DrugDetailViewModel = hiltViewModel()
) {
    val loading = viewModel.loading.value
    val drug = viewModel.drug.value
    Scaffold(
        topBar = {
            TopAppBar {
                Text(drug?.name ?: "Detail")
            }
        },
    ) {
        if (loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colors.onPrimary)

            }
        } else {
            Column(modifier = Modifier.padding(it)) {
                drug?.let {
                    DrugCard(drug = drug) {
                    }
                }

            }
        }
    }
}