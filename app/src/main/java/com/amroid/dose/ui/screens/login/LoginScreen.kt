package com.amroid.dose.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.amroid.dose.navigation.NavRoutes
import com.amroid.dose.ui.component.CustomTextField

@Composable
fun LoginScreen(navController: NavHostController) {

  Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.height(32.dp))
    Text("Login", style = MaterialTheme.typography.h4)
    Spacer(modifier = Modifier.height(16.dp))
    CustomTextField(title = "User Name", textState = "", onTextChange = {})
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(title = "Password", textState = "", onTextChange = {})

    Spacer(modifier = Modifier.height(32.dp))

    Button(onClick = {
     navController.navigate(NavRoutes.Home.route)
    }, modifier = Modifier.padding(horizontal = 10.dp,4.dp)) {
      Text("Log in")
    }
  }
}