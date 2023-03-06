package com.amroid.dose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amroid.dose.ui.screens.drugDetail.DrugDetailScreen
import com.amroid.dose.ui.screens.home.HomeScreen
import com.amroid.dose.ui.screens.login.LoginScreen
import com.amroid.dose.utils.STATE_KEY_DRUG_ID
import com.amroid.dose.utils.STATE_KEY_NAME

@Composable
fun MainScreen(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = NavRoutes.Login.route,
  ) {
    composable(NavRoutes.Login.route) {
      LoginScreen(navController = navController)
    }

    composable(route = NavRoutes.Home.route + "/{name}",
      arguments = listOf(navArgument(STATE_KEY_NAME) {
        type = NavType.StringType
      })) {
      HomeScreen(navController = navController)
    }

    composable(route=NavRoutes.Detail.route+ "/{drug_id}",
    arguments =listOf(navArgument(STATE_KEY_DRUG_ID) {
      type = NavType.IntType
    })
      ) {
      DrugDetailScreen(navController = navController)
    }
  }
}