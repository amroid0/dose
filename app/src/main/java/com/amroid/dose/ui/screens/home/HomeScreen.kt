package com.amroid.dose.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amroid.dose.data.model.DrugModel
import com.amroid.dose.navigation.NavRoutes
import com.amroid.dose.ui.component.DrugList
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val message = viewModel.greetingMsg.value
    val loading = viewModel.loading.value
    val drugs = viewModel.drugs.value
    Scaffold(
        topBar = {
            TopAppBar {
                Text("Home")
            }
        },
    ) {
        Column(modifier = Modifier.padding(it)) {
            Spacer(modifier = Modifier.height(height = 16.dp))
            Text(text = message, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(height = 32.dp))

            DrugList(
                loading = loading,
                drugs = drugs,
                onNavigateToDrugDetailScreen = { drug->
                    navController.navigate(NavRoutes.Detail.route+ "/${drug.id}")

                })

        }
    }
}