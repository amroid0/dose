package com.amroid.dose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amroid.dose.ui.screens.drugDetail.DrugDetailScreen
import com.amroid.dose.ui.screens.home.HomeScreen
import com.amroid.dose.ui.screens.login.LoginScreen

@Composable
fun MainScreen(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = NavRoutes.Login.route,
  ) {
    composable(NavRoutes.Login.route) {
      LoginScreen(navController = navController)
    }

    composable(NavRoutes.Home.route) {
      HomeScreen(navController = navController)
    }

    composable(NavRoutes.Detail.route) {
      DrugDetailScreen(navController = navController)
    }
  }
}