package com.amroid.dose.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amroid.dose.navigation.NavRoutes
import com.amroid.dose.ui.component.CustomTextField

@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    val user = viewModel.user
    val isLoading = viewModel.isLoading
    val loginSuccess = viewModel.loginSuccess
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("Login", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            title = "User Name",
            textState = user.email,
            onTextChange = { viewModel.onEmailChanged(it) })
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            title = "Password",
            textState = user.password,
            isPassword = true,
            onTextChange = { viewModel.onPasswordChanged(it) })

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { viewModel.onLoginClicked() },
            modifier = Modifier.padding(horizontal = 10.dp, 4.dp)
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.Magenta)
            } else {
                Text("Login")
            }
        }
    }
    if (loginSuccess) {
        LaunchedEffect(Unit) {
            navController.navigate(NavRoutes.Home.route+ "/${user.email}")
        }
    }
}