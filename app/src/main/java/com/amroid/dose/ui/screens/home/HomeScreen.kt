package com.amroid.dose.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.amroid.dose.data.model.DrugModel
import com.amroid.dose.navigation.NavRoutes
import com.amroid.dose.ui.component.DrugList

@Composable
fun HomeScreen(navController: NavHostController) {
DrugList(loading = true, drugs = listOf(), onNavigateToDrugDetailScreen = {
  navController.navigate(NavRoutes.Detail.route)

})
}