package com.amroid.dose.navigation

sealed class NavRoutes(val route: String) {
  object Login : NavRoutes("login")
  object Home : NavRoutes("home")
  object Detail : NavRoutes("detail")
}